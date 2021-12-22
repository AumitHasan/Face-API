package com.selise.facerecognition.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DetectRequest {
    private String image_url;
}
