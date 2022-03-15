package com.company;

public interface StatisticsDAO {

    void totalTeachers();
    void totalStudents();
    void totalEducations();
    void totalCourses();

    void minAgeTeachers();
    void maxAgeTeachers();
    void averageAgeTeachers();
    void teacherAboveForty();
    void teacherUnderOrEqualToForty();

    void minAgeStudents();
    void maxAgeStudents();
    void averageAgeStudents();
    void studentAboveThirty();
    void studentUnderOrEqualToThirty();

    void durationLongerThanTwelveMonths();
    void durationShorterTanThirteenMonths();
    void startDateAfter();
    void startDateBefore();

}
