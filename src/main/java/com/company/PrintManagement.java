package com.company;

import entity.Course;
import entity.Education;
import entity.Student;
import entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import static com.company.Utilities.emf;

public class PrintManagement implements PrintDAO {

    @Override
    public void printAllTeachers() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Teacher> teacherQuery= em.createNamedQuery("teacher.findAll", Teacher.class);

        teacherQuery.getResultList().forEach(System.out::println);
        }

    @Override
    public void printAllStudents() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Student> studentQuery = em.createNamedQuery("student.findAll", Student.class);

        studentQuery.getResultList().forEach(System.out::println);
    }

    @Override
    public void printAllEducations() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Education> educationQuery = em.createNamedQuery("education.findAll", Education.class);

        educationQuery.getResultList().forEach(System.out::println);
    }

    @Override
    public void printAllCourses() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Course> courseQuery = em.createNamedQuery("course.findAll", Course.class);

        courseQuery.getResultList().forEach(System.out::println);
    }

}

