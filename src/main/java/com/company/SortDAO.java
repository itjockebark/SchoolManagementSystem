package com.company;

public interface SortDAO {

    void sortTeacherByNameASC();
    void sortStudentByBirthdateASC();
    void sortEducationByNameASC();
    void sortEducationByEducationIdASC();
    void sortCourseByNameASC();

    void sortTeacherByNameDESC();
    void sortTeacherByBirthdateDESC();
    void sortStudentByIdDESC();
    void sortEducationByEducationIdDESC();
    void sortCourseByNameDESC();


}
