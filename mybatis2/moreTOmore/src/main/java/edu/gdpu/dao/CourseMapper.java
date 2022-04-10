package edu.gdpu.dao;

import edu.gdpu.pojo.Course;

public interface CourseMapper {
    public Course queryCourseByName(String name);
}
