package com.company;

import entity.Course;
import entity.Education;
import entity.Student;
import entity.Teacher;

import static com.company.Utilities.*;
import static com.company.UserInputManagement.*;

import javax.persistence.EntityManager;

public class AddAndConnectManagement implements AddAndConnectDAO {

    @Override
    public void addTeacher() {
        name = askAboutName();
        birthdate = askAboutBirthdate();

        Teacher teacher = new Teacher(name, birthdate);

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(teacher);
        em.getTransaction().commit();

        System.out.println("En ny lärare är nu tillagd: " + teacher);

        askUserToContinue();

        em.close();
    }

    @Override
    public void addStudent() {
        name = askAboutName();
        birthdate = askAboutBirthdate();

        Student student = new Student(name, birthdate);

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();

        System.out.println("En ny student är nu tillagd " + student);
        askUserToContinue();

        em.close();
    }

    @Override
    public void addEducation() {
        educationId = askAboutEducationId();
        name = askAboutName();
        startDate = askAboutStartDate();

        Education education = new Education(educationId, name,startDate);

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(education);
        em.getTransaction().commit();

        System.out.println("En ny utbildning är nu tillagd: " + education);
        askUserToContinue();

        em.close();
    }

    @Override
    public void addCourse() {
        courseId = askAboutCourseId();
        name = askAboutName();

        Course course = new Course(courseId, name);

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();

        System.out.println("En ny kurs är nu tillagd: " + course);
        askUserToContinue();

        em.close();
    }

    @Override
    public void connectTeacherToEducation() {
        printManagement.printAllTeachers();
        teacherId = askAboutTeacherId();

        printManagement.printAllEducations();
        educationId = askAboutEducationId();

        EntityManager em = emf.createEntityManager();

        Teacher teacher = em.find(Teacher.class, searchManagement.searchTeacherByIdAndReturnTeacherId(teacherId));
        Education education = em.find(Education.class, searchManagement.searchEducationByIdAndReturnEducationId(educationId));

        System.out.println("Läraren " + teacher.getName() + " och utbildningen " +
                education.getName() + " är nu kopplade.");
        askUserToContinue();

        em.getTransaction().begin();
        education.setTeacher(teacher);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void connectStudentToEducation() {
        printManagement.printAllStudents();
        studentId = askAboutStudentId();

        printManagement.printAllEducations();
        educationId = askAboutEducationId();

        EntityManager em = emf.createEntityManager();

        Student student = em.find(Student.class, searchManagement.searchStudentByIdAndReturnStudentId(studentId));
        Education education = em.find(Education.class, searchManagement.searchEducationByIdAndReturnEducationId(educationId));

        System.out.println("Studenten " + student.getName() + " och utbildningen " +
                education.getName() + " är nu kopplade.");
        askUserToContinue();

        em.getTransaction().begin();
        education.addStudent(student);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void connectCourseToEducation() {
        printManagement.printAllCourses();
        courseId = askAboutCourseId();

        printManagement.printAllEducations();
        educationId = askAboutEducationId();

        EntityManager em = emf.createEntityManager();

        Course course = em.find(Course.class, searchManagement.searchCourseByCourseIdAndReturnCourseId(courseId));
        Education education = em.find(Education.class, searchManagement.searchEducationByIdAndReturnEducationId(educationId));

        System.out.println("Kursen " + course.getName() + " och utbildningen " +
                education.getName() + " är nu kopplade.");
        askUserToContinue();

        em.getTransaction().begin();
        education.addCourse(course);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void addNewTeacherToExistingEducation() {
        name = askAboutName();
        birthdate = askAboutBirthdate();

        printManagement.printAllEducations();
        educationId = askAboutEducationId();

        EntityManager em = emf.createEntityManager();

        Teacher teacher = new Teacher(name, birthdate);
        Education education = searchManagement.searchEducationByEducationId(educationId);

        em.getTransaction().begin();
        em.persist(teacher);
        education.setTeacher(teacher);
        em.getTransaction().commit();

        System.out.println("En ny lärare vid namn " + teacher.getName() +
                " är nu skapad och är nu kopplad med utbildningen " + education.getName());
        askUserToContinue();

        em.close();
    }

    @Override
    public void addNewStudentToExistingEducation() {
        name = askAboutName();
        birthdate = askAboutBirthdate();

        printManagement.printAllEducations();
        educationId = askAboutEducationId();

        EntityManager em = emf.createEntityManager();

        Student student = new Student(name, birthdate);
        Education education = searchManagement.searchEducationByEducationId(educationId);

        em.getTransaction().begin();
        em.persist(student);
        education.addStudent(student);
        em.getTransaction().commit();

        System.out.println("En ny student vid namn " + student.getName() +
                " är nu skapad och är nu kopplad med utbildningen " + education.getName());
        askUserToContinue();

        em.close();
    }

    @Override
    public void addNewCourseToExistingEducation() {
        courseId = askAboutCourseId();
        name = askAboutName();

        printManagement.printAllEducations();
        educationId = askAboutEducationId();

        EntityManager em = emf.createEntityManager();

        Course course = new Course(courseId,name);
        Education education = searchManagement.searchEducationByEducationId(educationId);

        em.getTransaction().begin();
        em.persist(course);
        education.addCourse(course);
        em.getTransaction().commit();

        System.out.println("En ny kurs vid namn " + course.getName() +
                " är nu skapad och är nu kopplad med utbildningen " + education.getName());
        askUserToContinue();

        em.close();
    }

    @Override
    public void addFalseEntities() {
        addFakeTeachers();
        addFakeStudents();
        addFakeEducations();
        addFakeCourses();

        System.out.println("\nDu har nu lagt till 2 lärare, 10 studenter, 2 utbildnignar och 6 kurser utan koppling i databasen.");
        askUserToContinue();
    }

    private void addFakeTeachers() {
        EntityManager em = emf.createEntityManager();

        Teacher teacher1 = new Teacher("Bita Jabbari", "1986-09-12");
        Teacher teacher2 = new Teacher("Ulf Bilting", "1970-02-28");

        em.getTransaction().begin();

        em.persist(teacher1);
        em.persist(teacher2);

        em.getTransaction().commit();

        em.close();
    }

    private void addFakeStudents() {
        EntityManager em = emf.createEntityManager();

        Student student1 = new Student("Joakim Barkfjärd", "1994-11-29");
        Student student2 = new Student("Elias Johansson", "1995-02-20");
        Student student3 = new Student("Adam Olsson", "1993-10-21");
        Student student4 = new Student("William Persson", "1987-04-07");
        Student student5 = new Student("Filip Jönsson", "2000-11-05");
        Student student6 = new Student("Maja Karlsson", "1997-01-02");
        Student student7 = new Student("Stella Eriksson", "1999-04-25");
        Student student8 = new Student("Ebba Jonsson", "1982-01-25");
        Student student9 = new Student("Olivia Jansson", "1991-12-24");
        Student student10 = new Student("Isabelle Olofsson", "1979-03-11");

        em.getTransaction().begin();

        em.persist(student1);
        em.persist(student2);
        em.persist(student3);
        em.persist(student4);
        em.persist(student5);
        em.persist(student6);
        em.persist(student7);
        em.persist(student8);
        em.persist(student9);
        em.persist(student10);

        em.getTransaction().commit();

        em.close();
    }

    private void addFakeEducations() {
        EntityManager em = emf.createEntityManager();

        Education educationJava = new Education("JAVA2021", "Javautvecklare", "2020-07-14");
        Education educationJS = new Education("JS2019", "JavaScript-utvecklare", "2019-07-14");

        em.getTransaction().begin();

        em.persist(educationJava);
        em.persist(educationJS);

        em.getTransaction().commit();

        em.close();
    }

    private void addFakeCourses() {
        EntityManager em = emf.createEntityManager();

        Course courseJavaProgramming = new Course("JP144", "Java programmering");
        Course courseHTMLCSS = new Course("HC144", "HTML och CSS");
        Course courseDatabases = new Course("UMD139", "Utveckling mot databaser");
        Course courseAgileDevelopment = new Course("AD55", "Agil utveckling");
        Course courseCleanCode = new Course("CC655", "Clean code");
        Course courseLIA = new Course("LIA4", "LIA");


        em.getTransaction().begin();

        em.persist(courseJavaProgramming);
        em.persist(courseHTMLCSS);
        em.persist(courseDatabases);
        em.persist(courseAgileDevelopment);
        em.persist(courseCleanCode);
        em.persist(courseLIA);

        em.getTransaction().commit();

        em.close();
    }
}
