package edu.gdpu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class course_student {
    private int stu_id;
    private int course_id;
    private int grade;
}
