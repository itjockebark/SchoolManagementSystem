package com.company;

import entity.Course;
import entity.Education;
import entity.Student;
import entity.Teacher;

import javax.persistence.EntityManager;

import static com.company.UserInputManagement.*;
import static com.company.Utilities.*;
import static com.company.Utilities.teacherId;

public class RemoveAndDisconnectManagement implements RemoveAndDisconnectDAO {

    @Override
    public void removeTeacherById() {
        printManagement.printAllTeachers();
        teacherId = askAboutTeacherId();

        int newId = searchManagement.searchTeacherByIdAndReturnTeacherId(teacherId);

        setConnectedTeacherToNull(newId);

        EntityManager em = emf.createEntityManager();

        Teacher teacher = em.find(Teacher.class, newId);

        System.out.println("\nLäraren " + teacher.getName() + " är nu borttagen");
        askUserToContinue();

        em.getTransaction().begin();
        em.remove(teacher);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void removeStudentById() {
        printManagement.printAllStudents();
        studentId = askAboutStudentId();

        Student student = searchManagement.searchStudentByStudentId(studentId);

        EntityManager em = emf.createEntityManager();

        System.out.println("\nStudenten " + student.getName() + " är nu borttagen");
        askUserToContinue();

        em.getTransaction().begin();
        Student removeStudent = em.merge(student);
        em.remove(removeStudent);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void removeEducationById() {
        printManagement.printAllEducations();
        educationId = askAboutEducationId();

        EntityManager em = emf.createEntityManager();

        Education education = em.find(Education.class, searchManagement.searchEducationByIdAndReturnEducationId(educationId));

        System.out.println("\nUtbildningen " + education.getName() + " är nu borttagen");
        askUserToContinue();

        em.getTransaction().begin();
        education.getStudents().forEach(c -> c.setEducation(null));
        Education removeEducation = em.merge(education);
        em.remove(removeEducation);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void removeCourseById() {
        printManagement.printAllCourses();
        courseId = askAboutCourseId();

        Course course = searchManagement.searchCourseByCourseId(courseId);

        System.out.println("\nKursen " + course.getName() + " är nu borttagen");
        askUserToContinue();

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Course removeCourse = em.merge(course);
        em.remove(removeCourse);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void removeTeacherByName() {
        printManagement.printAllTeachers();

        name = askAboutName();

        int newId = searchManagement.searchTeacherByNameAndReturnInt(name);

        setConnectedTeacherToNull(newId);

        EntityManager em = emf.createEntityManager();

        Teacher teacher = em.find(Teacher.class, newId);

        System.out.println("\nLäraren " + teacher.getName() + " är nu borttagen");
        askUserToContinue();

        em.getTransaction().begin();
        em.remove(teacher);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void removeStudentByName() {
        printManagement.printAllStudents();
        name = askAboutName();

        Student student = searchManagement.searchStudentByName(name);

        System.out.println("\nStudenten " + student.getName() + " är nu borttagen");
        askUserToContinue();

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Student removeStudent = em.merge(student);
        em.remove(removeStudent);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void removeEducationByName() {
        printManagement.printAllEducations();
        name = askAboutName();

        EntityManager em = emf.createEntityManager();

        Education education = em.find(Education.class, searchManagement.searchEducationByNameAndReturnEducationId(name));

        System.out.println("\nUtbildningen " + education.getName() + " är nu borttagen");
        askUserToContinue();

        em.getTransaction().begin();
        education.getStudents().forEach(c -> c.setEducation(null));
        Education removeEducation = em.merge(education);
        em.remove(removeEducation);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void removeCourseByName() {
        printManagement.printAllCourses();
        name = askAboutName();

        Course course = searchManagement.searchCourseByName(name);

        System.out.println("\nKursen " + course.getName() + " är nu borttagen");
        askUserToContinue();

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Course removeCourse = em.merge(course);
        em.remove(removeCourse);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void disconnectTeacherFromEducation() {
        printManagement.printAllTeachers();
        teacherId = askAboutTeacherId();

        int newId = searchManagement.searchTeacherByIdAndReturnTeacherId(teacherId);

        setConnectedTeacherToNull(newId);

        EntityManager em = emf.createEntityManager();
        Teacher teacher = em.find(Teacher.class, newId);

        System.out.println("\nLäraren " + teacher.getName() + " är inte längre kopplad till någon utbildning.");
        askUserToContinue();
        em.close();
    }

    @Override
    public void disconnectStudentFromEducation() {
        printManagement.printAllStudents();
        studentId = askAboutStudentId();

        printManagement.printAllEducations();
        educationId = askAboutEducationId();

        EntityManager em = emf.createEntityManager();

        Student student = em.find(Student.class, searchManagement.searchStudentByIdAndReturnStudentId(studentId));
        Education education = em.find(Education.class, searchManagement.searchEducationByIdAndReturnEducationId(educationId));

        System.out.println("\nStudenten " + student.getName() + " och utbildningen " +
                education.getName() + " är nu ifrånkopplade");
        askUserToContinue();

        em.getTransaction().begin();
        education.removeStudent(student);
        em.getTransaction().commit();

        em.close();
    }

    @Override
    public void disconnectCourseFomEducation() {
        printManagement.printAllCourses();
        courseId = askAboutCourseId();

        printManagement.printAllEducations();
        educationId = askAboutEducationId();

        EntityManager em = emf.createEntityManager();

        Course course = em.find(Course.class, searchManagement.searchCourseByCourseIdAndReturnCourseId(courseId));
        Education education = em.find(Education.class, searchManagement.searchEducationByIdAndReturnEducationId(educationId));

        System.out.println("\nKursen " + course.getName() + " och utbildningen " +
                education.getName() + " är nu ifrånkopplade");
        askUserToContinue();

        em.getTransaction().begin();
        education.removeCourse(course);
        em.getTransaction().commit();

        em.close();
    }
}
