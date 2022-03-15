package com.company;

import entity.Course;
import entity.Education;
import entity.Student;
import entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import static com.company.UserInputManagement.askUserToContinue;
import static com.company.Utilities.emf;

public class SortManagement implements SortDAO{

    @Override
    public void sortTeacherByNameASC() {
        {
            EntityManager em = emf.createEntityManager();

            TypedQuery<Teacher> teacherTypedQuery = em.createNamedQuery("teacher.sortByNameASC", Teacher.class);

            teacherTypedQuery.getResultList().forEach(System.out::println);

            askUserToContinue();
            em.close();
        }
    }

    @Override
    public void sortStudentByBirthdateASC() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Student> studentTypedQuery = em.createNamedQuery("student.sortByBirthdateASC", Student.class);

        studentTypedQuery.getResultList().forEach(System.out::println);

        askUserToContinue();
        em.close();
    }

    @Override
    public void sortEducationByEducationIdASC() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Education> educationTypedQuery = em.createNamedQuery("education.sortByEducationIdASC", Education.class);

        educationTypedQuery.getResultList().forEach(System.out::println);

        askUserToContinue();
        em.close();
    }

    @Override
    public void sortEducationByNameASC() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Education> educationTypedQuery = em.createNamedQuery("education.sortByNameASC", Education.class);

        educationTypedQuery.getResultList().forEach(System.out::println);

        askUserToContinue();
        em.close();
    }

    @Override
    public void sortCourseByNameASC() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Course> courseTypedQuery = em.createNamedQuery("course.sortByNameASC", Course.class);

        courseTypedQuery.getResultList().forEach(System.out::println);

        askUserToContinue();
        em.close();
    }

    @Override
    public void sortTeacherByNameDESC() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Teacher> teacherTypedQuery = em.createNamedQuery("teacher.sortByNameDESC", Teacher.class);

        teacherTypedQuery.getResultList().forEach(System.out::println);

        askUserToContinue();
        em.close();
    }

    @Override
    public void sortTeacherByBirthdateDESC() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Teacher> teacherTypedQuery = em.createNamedQuery("teacher.sortByBirthdateDESC", Teacher.class);

        teacherTypedQuery.getResultList().forEach(System.out::println);

        askUserToContinue();
        em.close();
    }

    @Override
    public void sortStudentByIdDESC() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Student> studentTypedQuery = em.createNamedQuery("student.sortByStudentIdDESC", Student.class);

        studentTypedQuery.getResultList().forEach(System.out::println);

        askUserToContinue();
        em.close();
    }

    @Override
    public void sortEducationByEducationIdDESC() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Education> educationTypedQuery = em.createNamedQuery("education.sortByEducationIdDESC", Education.class);

        educationTypedQuery.getResultList().forEach(System.out::println);

        askUserToContinue();
        em.close();
    }

    @Override
    public void sortCourseByNameDESC() {
        EntityManager em = emf.createEntityManager();

        TypedQuery<Course> courseTypedQuery = em.createNamedQuery("course.sortByNameDESC", Course.class);

        courseTypedQuery.getResultList().forEach(System.out::println);

        askUserToContinue();
        em.close();
    }
}
