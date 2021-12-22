package com.selise.facerecognition.service.impl;

import com.selise.facerecognition.model.*;
import com.selise.facerecognition.service.FaceRecognitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;

@Service
public class FaceRecognitionServiceImpl implements FaceRecognitionService {

    @Autowired
    Environment environment;

    RestTemplate restTemplate;

    HttpHeaders httpHeaders;

    private String api_key;
    private String api_secret;
    private String detectUrl;
    private String compareUrl;
    private String detectApiAttribute;

    public FaceRecognitionServiceImpl() {
        restTemplate = new RestTemplate();
        httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.ACCEPT, "*/*");
    }

    @PostConstruct
    public void inti() {
        api_key = environment.getProperty("api_key");
        api_secret = environment.getProperty("api_secret");
        detectUrl = environment.getProperty("detect.url");
        compareUrl = environment.getProperty("compare.url");
        detectApiAttribute = environment.getProperty("detect.attribute");
    }

    @Override
    public DetectResponse getFaceDetectResult(DetectRequest request) {
        DetectResponse response = new DetectResponse();

        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(detectUrl)
                .queryParam("api_key", api_key)
                .queryParam("api_secret", api_secret)
                .queryParam("image_url", request.getImage_url().toString())
                .queryParam("return_attributes", detectApiAttribute);

        try {
            ResponseEntity<DetectResponse> httpResponse = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, DetectResponse.class);
            response =  httpResponse.getBody();
        }
        catch (HttpClientErrorException e) {
            response.setError(e.getMessage());
            e.printStackTrace();
        }

        return response;
    }

    @Override
    public CompareResponse getComparisonResult(CompareRequest request) throws Exception {
        CompareResponse response = new CompareResponse();

        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(compareUrl)
                .queryParam("api_key", api_key)
                .queryParam("api_secret", api_secret)
                .queryParam("image_url1", request.getImageUrl().toString())
                .queryParam("image_url2", request.getImageUrlToCompare().toString());

        try {
            ResponseEntity<CompareResponse> httpResponse = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, entity, CompareResponse.class);
            response = httpResponse.getBody();
        }
        catch(HttpClientErrorException e) {
            e.printStackTrace();
            response.setError(e.getMessage());
        }

        return response;
    }

}
