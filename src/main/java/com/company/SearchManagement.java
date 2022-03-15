package com.company;

import entity.*;
import entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import static com.company.UserInputManagement.*;
import static com.company.Utilities.*;


public class SearchManagement implements SearchDAO {

    @Override
    public Teacher searchTeacherByTeacherId(int teacherId) {
        while (true) {
            try {
                EntityManager em = emf.createEntityManager();
                Query teacherQuery = em.createNamedQuery("teacher.findById");
                teacherQuery.setParameter("teacherId", teacherId);
                Teacher teacher = (Teacher) teacherQuery.getSingleResult();
                return teacher;
            } catch (Exception exception) {
                displayWrongInputText();
                teacherId = askAboutTeacherId();
            }
        }
    }

    @Override
    public int searchTeacherByNameAndReturnInt(String name) {
        while (true) {
            try {
                EntityManager em = emf.createEntityManager();
                Query teacherQuery = em.createNamedQuery("teacher.findByName");
                teacherQuery.setParameter("name", name);
                Teacher teacher = (Teacher) teacherQuery.getSingleResult();
                teacherId = teacher.getTeacherId();
                return teacherId;
            } catch (Exception exception) {
                displayWrongInputText();
                name = askAboutName();
            }
        }
    }

    @Override
    public int searchTeacherByIdAndReturnTeacherId(int teacherId) {
        while (true) {
            try {
                EntityManager em = emf.createEntityManager();
                Query teacherQuery = em.createNamedQuery("teacher.findById");
                teacherQuery.setParameter("teacherId", teacherId);
                Teacher teacher = (Teacher) teacherQuery.getSingleResult();
                return teacherId;
            } catch (Exception exception) {
                displayWrongInputText();
                teacherId = askAboutTeacherId();
            }
        }
    }

    @Override
    public Student searchStudentByStudentId(int studentId) {
        while (true) {
            try {
                EntityManager em = emf.createEntityManager();
                Query studentQuery = em.createNamedQuery("student.findById");
                studentQuery.setParameter("studentId", studentId);
                Student student = (Student) studentQuery.getSingleResult();
                return student;
            } catch (Exception exception) {
                displayWrongInputText();
                studentId = askAboutStudentId();
            }
        }
    }

    @Override
    public Student searchStudentByName(String name) {
        while (true) {
            try {
                EntityManager em = emf.createEntityManager();
                Query studentQuery = em.createNamedQuery("student.findByName");
                studentQuery.setParameter("name", name);
                Student student = (Student) studentQuery.getSingleResult();
                return student;
            } catch (Exception exception) {
                displayWrongInputText();
                name = askAboutName();
            }
        }
    }

    @Override
    public int searchStudentByIdAndReturnStudentId(int studentId) {
        while (true) {
            try {
                EntityManager em = emf.createEntityManager();
                Query studentQuery = em.createNamedQuery("student.findById");
                studentQuery.setParameter("studentId", studentId);
                Student student = (Student) studentQuery.getSingleResult();
                return studentId;
            } catch (Exception exception) {
                displayWrongInputText();
                studentId = askAboutStudentId();
            }
        }
    }

    @Override
    public Education searchEducationByEducationId(String educationId) {
        while (true) {
            try {
                EntityManager em = emf.createEntityManager();
                Query educationQuery = em.createNamedQuery("education.findById");
                educationQuery.setParameter("educationId", educationId);
                Education education = (Education) educationQuery.getSingleResult();
                return education;
            } catch (Exception exception) {
                displayWrongInputText();
                educationId = askAboutEducationId();
            }
        }
    }

    @Override
    public Education searchEducationByName(String name) {
        while (true) {
            try {
                EntityManager em = emf.createEntityManager();
                Query educationQuery = em.createNamedQuery("education.findByName");
                educationQuery.setParameter("name", name);
                Education education = (Education) educationQuery.getSingleResult();
                return education;
            } catch (Exception exception) {
                displayWrongInputText();
                name = askAboutName();
            }
        }
    }

    @Override
    public String searchEducationByIdAndReturnEducationId(String educationId) {
        while (true) {
            try {
                EntityManager em = emf.createEntityManager();
                Query educationQuery = em.createNamedQuery("education.findById");
                educationQuery.setParameter("educationId", educationId);
                Education education = (Education) educationQuery.getSingleResult();
                return educationId;
            } catch (Exception exception) {
                displayWrongInputText();
                educationId = askAboutEducationId();
            }
        }
    }

    @Override
    public String searchEducationByNameAndReturnEducationId(String name) {
        while (true) {
            try {
                EntityManager em = emf.createEntityManager();
                Query educationQuery = em.createNamedQuery("education.findByName");
                educationQuery.setParameter("name", name);
                Education education = (Education) educationQuery.getSingleResult();
                String educationId = education.getEducationId();
                return educationId;
            } catch (Exception exception) {
                displayWrongInputText();
                name = askAboutName();
            }
        }
    }

    @Override
    public Course searchCourseByCourseId(String courseId) {
        while (true) {
            try {
                EntityManager em = emf.createEntityManager();
                Query courseQuery = em.createNamedQuery("course.findById");
                courseQuery.setParameter("courseId", courseId);
                Course course = (Course) courseQuery.getSingleResult();
                return course;
            } catch (Exception exception) {
                displayWrongInputText();
                courseId = askAboutCourseId();
            }
        }
    }

    @Override
    public Course searchCourseByName(String name) {
        while (true) {
            try {
                EntityManager em = emf.createEntityManager();
                Query courseQuery = em.createNamedQuery("course.findByName");
                courseQuery.setParameter("name", name);
                Course course = (Course) courseQuery.getSingleResult();
                return course;
            } catch (Exception exception) {
                displayWrongInputText();
                name = askAboutName();
            }
        }
    }

    @Override
    public String searchCourseByCourseIdAndReturnCourseId(String courseId) {
        while (true) {
            try {
                EntityManager em = emf.createEntityManager();
                Query courseQuery = em.createNamedQuery("course.findById");
                courseQuery.setParameter("courseId", courseId);
                Course course = (Course) courseQuery.getSingleResult();
                return courseId;
            } catch (Exception exception) {
                displayWrongInputText();
                courseId = askAboutEducationId();
            }
        }
    }
}
