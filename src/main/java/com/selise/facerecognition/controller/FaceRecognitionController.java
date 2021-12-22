package com.selise.facerecognition.controller;

import com.selise.facerecognition.model.*;
import com.selise.facerecognition.service.impl.FaceRecognitionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class FaceRecognitionController {

    @Autowired
    private FaceRecognitionServiceImpl faceRecognitionServiceImpl;

    @PostMapping("/detect")
    public ResponseEntity<DetectResponse> getDetectFaceResult(@RequestBody DetectRequest request) {
        try {
            return new ResponseEntity<>(faceRecognitionServiceImpl.getFaceDetectResult(request), HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/compare")
    public ResponseEntity<CompareResponse> getComparisonResult(@RequestBody CompareRequest request) {
        System.out.println(request.getImageUrl() + "\n" + request.getImageUrlToCompare());
        try {
            return new ResponseEntity<>(faceRecognitionServiceImpl.getComparisonResult(request), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
