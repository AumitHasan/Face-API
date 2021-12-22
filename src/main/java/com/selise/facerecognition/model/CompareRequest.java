package com.selise.facerecognition.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompareRequest {

    private String imageUrl;
    private String imageUrlToCompare;


}
