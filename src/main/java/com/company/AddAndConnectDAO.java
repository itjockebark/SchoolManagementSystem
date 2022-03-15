package com.company;

public interface AddAndConnectDAO {

    void addTeacher();
    void addStudent();
    void addEducation();
    void addCourse();

    void connectTeacherToEducation();
    void connectStudentToEducation();
    void connectCourseToEducation();

    void addNewTeacherToExistingEducation();
    void addNewStudentToExistingEducation();
    void addNewCourseToExistingEducation();

    void addFalseEntities();

}
