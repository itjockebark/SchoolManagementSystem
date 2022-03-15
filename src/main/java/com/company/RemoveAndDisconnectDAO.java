package com.company;

public interface RemoveAndDisconnectDAO {

    void removeTeacherById();

    void removeStudentById();

    void removeEducationById();

    void removeCourseById();

    void removeTeacherByName();

    void removeStudentByName();

    void removeEducationByName();

    void removeCourseByName();

    void disconnectTeacherFromEducation();

    void disconnectStudentFromEducation();

    void disconnectCourseFomEducation();



}
