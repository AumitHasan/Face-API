package com.selise.facerecognition.service;

import com.selise.facerecognition.model.CompareRequest;
import com.selise.facerecognition.model.DetectRequest;

public interface FaceRecognitionService {

    Object getFaceDetectResult(DetectRequest request) throws Exception;

    Object getComparisonResult(CompareRequest request) throws Exception;

}
