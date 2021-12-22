package com.selise.facerecognition.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class DetectResponse {

    private String request_id;
    private int time_used;
    private List<Face> faces;
    private String image_id;
    private int face_num;
    private Object error;
}

@Data
@NoArgsConstructor
class FaceRectangle{
    private int top;
    private int left;
    private int width;
    private int height;
}

@Data
@NoArgsConstructor
class Gender{
    private String value;
}

@Data
@NoArgsConstructor
class Age{
    private int value;
}

@Data
@NoArgsConstructor
class Smile{
    private double value;
    private double threshold;
}

@Data
@NoArgsConstructor
class Headpose{
    private double pitch_angle;
    private double roll_angle;
    private double yaw_angle;
}

@Data
@NoArgsConstructor
class Blurness{
    private double value;
    private double threshold;
}

@Data
@NoArgsConstructor
class Motionblur{
    private double value;
    private double threshold;
}

@Data
@NoArgsConstructor
class Gaussianblur{
    private double value;
    private double threshold;
}

@Data
@NoArgsConstructor
class Blur{
    private Blurness blurness;
    private Motionblur motionblur;
    private Gaussianblur gaussianblur;
}

@Data
@NoArgsConstructor
class LeftEyeStatus{
    private double no_glass_eye_open;
    private double no_glass_eye_close;
    private double normal_glass_eye_open;
    private double normal_glass_eye_close;
    private double dark_glasses;
    private double occlusion;
}

@Data
@NoArgsConstructor
class RightEyeStatus{
    private double no_glass_eye_open;
    private double no_glass_eye_close;
    private double normal_glass_eye_open;
    private double normal_glass_eye_close;
    private double dark_glasses;
    private double occlusion;
}

@Data
@NoArgsConstructor
class Eyestatus{
    private LeftEyeStatus left_eye_status;
    private RightEyeStatus right_eye_status;
}

@Data
@NoArgsConstructor
class Emotion{
    private double anger;
    private double disgust;
    private double fear;
    private double happiness;
    private double neutral;
    private double sadness;
    private double surprise;
}

@Data
@NoArgsConstructor
class Facequality{
    private double value;
    private double threshold;
}

@Data
@NoArgsConstructor
class Ethnicity{
    private String value;
}

@Data
@NoArgsConstructor
class Beauty{
    private double male_score;
    private double female_score;
}

@Data
@NoArgsConstructor
class Mouthstatus{
    private double surgical_mask_or_respirator;
    private double other_occlusion;
    private double close;
    private double open;
}

@Data
@NoArgsConstructor
class LeftEyeGaze{
    private double position_x_coordinate;
    private double position_y_coordinate;
    private double vector_x_component;
    private double vector_y_component;
    private double vector_z_component;
}

@Data
@NoArgsConstructor
class RightEyeGaze{
    private double position_x_coordinate;
    private double position_y_coordinate;
    private double vector_x_component;
    private double vector_y_component;
    private double vector_z_component;
}

@Data
@NoArgsConstructor
class Eyegaze{
    private LeftEyeGaze left_eye_gaze;
    private RightEyeGaze right_eye_gaze;
}

@Data
@NoArgsConstructor
class Skinstatus{
    private double health;
    private double stain;
    private double dark_circle;
    private double acne;
}

@Data
@NoArgsConstructor
class Glass{
    private String value;
}

@Data
@NoArgsConstructor
class Attributes{
    private Gender gender;
    private Age age;
    private Smile smile;
    private Headpose headpose;
    private Blur blur;
    private Eyestatus eyestatus;
    private Emotion emotion;
    private Facequality facequality;
    private Ethnicity ethnicity;
    private Beauty beauty;
    private Mouthstatus mouthstatus;
    private Eyegaze eyegaze;
    private Skinstatus skinstatus;
    private Glass glass;
}

@Data
@NoArgsConstructor
class Face{
    private String face_token;
    private FaceRectangle face_rectangle;
    private Attributes attributes;
}



