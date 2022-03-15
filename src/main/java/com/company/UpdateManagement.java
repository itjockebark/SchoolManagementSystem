package com.company;

import entity.Course;
import entity.Education;
import entity.Student;
import entity.Teacher;

import javax.persistence.EntityManager;

import static com.company.UserInputManagement.*;
import static com.company.Utilities.*;

public class UpdateManagement implements UpdateDAO {

    @Override
    public void updateTeacherName() {
        printManagement.printAllTeachers();
        teacherId = askAboutTeacherId();

        EntityManager em = emf.createEntityManager();

        Teacher teacher =  em.find(Teacher.class, searchManagement.searchTeacherByIdAndReturnTeacherId(teacherId));

        System.out.print("Ange nytt namn: ");
        name = stringScanner();

        em.getTransaction().begin();
        teacher.setName(name);
        em.getTransaction().commit();

        System.out.println("\nNamnet på läraren är nu: " + teacher.getName());
        askUserToContinue();

        em.close();

    }

    @Override
    public void updateTeacherBirthdate() {
        printManagement.printAllTeachers();
        teacherId = askAboutTeacherId();

        EntityManager em = emf.createEntityManager();

        Teacher teacher =  em.find(Teacher.class, searchManagement.searchTeacherByIdAndReturnTeacherId(teacherId));

        System.out.print("Ange nytt födelsedatum: ");
        birthdate = stringScanner();

        em.getTransaction().begin();
        teacher.setBirthdate(birthdate);
        em.getTransaction().commit();

        System.out.println("\nFödelsedatumet på läraren är nu: " + teacher.getBirthdate());
        askUserToContinue();

        em.close();
    }

    @Override
    public void updateStudentName() {
        printManagement.printAllStudents();
        studentId = askAboutStudentId();

        EntityManager em = emf.createEntityManager();

        Student student = em.find(Student.class, searchManagement.searchStudentByIdAndReturnStudentId(studentId));

        System.out.print("Ange nytt namn: ");
        name = stringScanner();

        em.getTransaction().begin();
        student.setName(name);
        em.getTransaction().commit();

        System.out.println("\nNamnet på studenten är nu: " + student.getName());
        askUserToContinue();
        em.close();
    }

    @Override
    public void updateStudentBirthdate() {
        printManagement.printAllStudents();
        studentId = askAboutStudentId();

        EntityManager em = emf.createEntityManager();

        Student student = em.find(Student.class, searchManagement.searchStudentByIdAndReturnStudentId(studentId));

        System.out.print("Ange nytt födelsedatum: ");
        birthdate = stringScanner();

        em.getTransaction().begin();
        student.setBirthdate(birthdate);
        em.getTransaction().commit();

        System.out.println("\nFödelsedatumet på studenten är nu: " + student.getBirthdate());
        askUserToContinue();
        em.close();
    }

    @Override
    public void updateEducationName() {
        printManagement.printAllEducations();
        educationId = askAboutEducationId();

        EntityManager em = emf.createEntityManager();

        Education education = em.find(Education.class, searchManagement.searchEducationByIdAndReturnEducationId(educationId));

        System.out.print("Ange nytt namn: ");
        name = stringScanner();

        em.getTransaction().begin();
        education.setName(name);
        em.getTransaction().commit();

        System.out.println("\nNamnet på utbildningen är nu: " + education.getName());
        askUserToContinue();
        em.close();
    }

    @Override
    public void updateEducationStartDate() {
        printManagement.printAllEducations();
        educationId = askAboutEducationId();

        EntityManager em = emf.createEntityManager();

        Education education = em.find(Education.class, searchManagement.searchEducationByIdAndReturnEducationId(educationId));

        System.out.print("Ange nytt startdatum: ");
        startDate = stringScanner();

        em.getTransaction().begin();
        education.setStartDate(startDate);
        em.getTransaction().commit();

        System.out.println("\nStartdatumet på utbildningen är nu: " + education.getStartDate());
        askUserToContinue();
        em.close();
    }

    @Override
    public void updateCourseName() {
        printManagement.printAllCourses();
        courseId = askAboutCourseId();

        EntityManager em = emf.createEntityManager();
        Course course = em.find(Course.class, searchManagement.searchCourseByCourseIdAndReturnCourseId(courseId));

        System.out.print("Ange nytt namn: ");
        name = stringScanner();

        em.getTransaction().begin();
        course.setName(name);
        em.getTransaction().commit();

        System.out.println("\nNamnet på kursen är nu: " + course.getName());
        askUserToContinue();
        em.close();
    }
}
