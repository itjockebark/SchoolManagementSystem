package com.company;

import entity.Course;
import entity.Education;
import entity.Student;
import entity.Teacher;

public interface SearchDAO {

    Teacher searchTeacherByTeacherId(int teacherId);
    int searchTeacherByNameAndReturnInt(String name);
    int searchTeacherByIdAndReturnTeacherId(int teacherId);

    Student searchStudentByStudentId(int studentId);
    Student searchStudentByName(String name);
    int searchStudentByIdAndReturnStudentId(int studentId);

    Education searchEducationByEducationId(String educationId);
    Education searchEducationByName(String name);
    String searchEducationByIdAndReturnEducationId(String educationId);
    String searchEducationByNameAndReturnEducationId(String name);

    Course searchCourseByCourseId(String courseId);
    Course searchCourseByName(String name);
    String searchCourseByCourseIdAndReturnCourseId(String courseId);


}