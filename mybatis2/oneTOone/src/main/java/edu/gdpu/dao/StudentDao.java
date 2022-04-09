package edu.gdpu.dao;

import edu.gdpu.pojo.Student;


public interface StudentDao {
    public void addStudent(Student student,int class_id);

    public Student queryStudent1(int id);

    public Student queryStudent2(int id);
}
