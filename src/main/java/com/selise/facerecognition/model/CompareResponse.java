package com.selise.facerecognition.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CompareResponse {
    private List<Faces1> faces1;
    private List<Faces2> faces2;
    private int time_used;
    private Thresholds thresholds;
    private double confidence;
    private String image_id2;
    private String image_id1;
    private String request_id;
    private String error;
}

@Data
@NoArgsConstructor
 class Faces1{
    private FaceRectangle face_rectangle;
    private String face_token;
}

@Data
@NoArgsConstructor
 class Faces2{
    private FaceRectangle face_rectangle;
    private String face_token;
}

@Data
@NoArgsConstructor
 class Thresholds{
    private double _1e3;
    private double _1e5;
    private double _1e4;
}
