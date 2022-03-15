package com.company;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import static com.company.UserInputManagement.askUserToContinue;
import static com.company.Utilities.emf;

public class StatisticsManagement implements StatisticsDAO{

    @Override
    public void totalTeachers() {
        EntityManager em = emf.createEntityManager();

        Query teacherQuery = em.createNamedQuery("teacher.total");

        long totalTeachers = (long) teacherQuery.getSingleResult();

        System.out.println("\nTotalt antal lärare: " + totalTeachers);

        askUserToContinue();
        em.close();
    }

    @Override
    public void totalStudents() {
        EntityManager em = emf.createEntityManager();

        Query studentQuery = em.createNamedQuery("student.total");

        long totalStudents = (long) studentQuery.getSingleResult();

        System.out.println("\nTotalt antal studenter: " + totalStudents);

        askUserToContinue();
        em.close();
    }

    @Override
    public void totalEducations() {
        EntityManager em = emf.createEntityManager();

        Query educationQuery = em.createNamedQuery("education.total");

        long totalEducations = (long) educationQuery.getSingleResult();

        System.out.println("\nTotalt antal utbildningar: " + totalEducations);

        askUserToContinue();
        em.close();
    }

    @Override
    public void totalCourses() {
        EntityManager em = emf.createEntityManager();

        Query courseQuery = em.createNamedQuery("course.total");

        long totalCourses = (long) courseQuery.getSingleResult();

        System.out.println("\nTotalt antal kurser: " + totalCourses);

        askUserToContinue();
        em.close();
    }

    @Override
    public void minAgeTeachers() {
        EntityManager em = emf.createEntityManager();

        Query teacherQuery = em.createNamedQuery("teacher.minAge");

        double teacherMinAge = (double) teacherQuery.getSingleResult();

        System.out.println("\nDen lägsta åldern på en lärare är: " + teacherMinAge);

        askUserToContinue();
        em.close();
    }

    @Override
    public void maxAgeTeachers() {
        EntityManager em = emf.createEntityManager();

        Query teacherQuery = em.createNamedQuery("teacher.maxAge");

        double teacherMaxAge = (double) teacherQuery.getSingleResult();

        System.out.println("\nDen högsta åldern på en lärare är: " + teacherMaxAge);

        askUserToContinue();
        em.close();
    }

    @Override
    public void averageAgeTeachers() {
        EntityManager em = emf.createEntityManager();

        Query teacherQuery = em.createNamedQuery("teacher.averageAge");

        double teacherAverageAge = (double) teacherQuery.getSingleResult();

        System.out.println("\nDen genomsnittliga ålderna på en lärare är: " + teacherAverageAge);

        askUserToContinue();
        em.close();
    }

    @Override
    public void minAgeStudents() {
        EntityManager em = emf.createEntityManager();

        Query studentQuery = em.createNamedQuery("student.minAge");

        double studentMinAge = (double) studentQuery.getSingleResult();

        System.out.println("\nDen lägsta åldern på en student är: " + studentMinAge);

        askUserToContinue();
        em.close();
    }

    @Override
    public void maxAgeStudents() {
        EntityManager em = emf.createEntityManager();

        Query studentQuery = em.createNamedQuery("student.maxAge");

        double studentMaxAge = (double) studentQuery.getSingleResult();

        System.out.println("\nDen högsta åldern på en student är: " + studentMaxAge);

        askUserToContinue();
        em.close();
    }

    @Override
    public void averageAgeStudents() {
        EntityManager em = emf.createEntityManager();

        Query studentQuery = em.createNamedQuery("student.averageAge");

        double studentAverageAge = (double) studentQuery.getSingleResult();

        System.out.println("\nDen genomsnittliga åldern på en student är: " + studentAverageAge);

        askUserToContinue();
        em.close();
    }

    @Override
    public void studentAboveThirty() {
        EntityManager em = emf.createEntityManager();

        Query studentQuery = em.createNamedQuery("student.aboveThirty");

        long studentAboveThirty = (long) studentQuery.getSingleResult();

        System.out.println("\nAntalet studenter som är äldre än 30 år: " + studentAboveThirty);

        askUserToContinue();
        em.close();
    }

    @Override
    public void studentUnderOrEqualToThirty() {
        EntityManager em = emf.createEntityManager();

        Query studentQuery = em.createNamedQuery("student.underOrEqualToThirty");

        long studentUnderOrEqualToThirty = (long) studentQuery.getSingleResult();

        System.out.println("\nAntalet studenter som är yngre än 30 eller är 30 år gamla: " + studentUnderOrEqualToThirty);

        askUserToContinue();
        em.close();
    }

    @Override
    public void durationLongerThanTwelveMonths() {
        EntityManager em = emf.createEntityManager();

        Query educationQuery = em.createNamedQuery("education.durationLongerThanTwelveMonths");

        long durationLonger = (long) educationQuery.getSingleResult();

        System.out.println("\nAntalet utbildningar med varaktighet längre än 12 månader: " + durationLonger);

        askUserToContinue();
        em.close();
    }

    @Override
    public void durationShorterTanThirteenMonths() {
        EntityManager em = emf.createEntityManager();

        Query educationQuery = em.createNamedQuery("education.durationShorterThanThirteenMonths");

        long durationLonger = (long) educationQuery.getSingleResult();

        System.out.println("\nAntalet utbildningar med varaktighet på 12 månader eller kortare: " + durationLonger);

        askUserToContinue();
        em.close();
    }

    @Override
    public void startDateAfter() {
        EntityManager em = emf.createEntityManager();

        Query educationQuery = em.createNamedQuery("education.startDateAfter20200714");

        long startDateAfter = (long) educationQuery.getSingleResult();

        System.out.println("\nAntalet utbildningar med startdatum efter 2020-07-14: " + startDateAfter);

        askUserToContinue();
        em.close();
    }

    @Override
    public void startDateBefore() {
        EntityManager em = emf.createEntityManager();

        Query educationQuery = em.createNamedQuery("education.startDateBefore20200714");

        long startDateBefore = (long) educationQuery.getSingleResult();

        System.out.println("\nAntalet utbildningar med startdatum innan 2020-07-14: " + startDateBefore);

        askUserToContinue();
        em.close();
    }

    @Override
    public void teacherAboveForty() {
        EntityManager em = emf.createEntityManager();

        Query teacherQuery = em.createNamedQuery("teacher.aboveForty");

        long teacherAboveForty = (long) teacherQuery.getSingleResult();

        System.out.println("\nAntalet lärare som är äldre än 40 år: " + teacherAboveForty);

        askUserToContinue();
        em.close();
    }

    @Override
    public void teacherUnderOrEqualToForty() {
        EntityManager em = emf.createEntityManager();

        Query teacherQuery = em.createNamedQuery("teacher.underOrEqualToForty");

        long teacherUnderOrEqualToForty = (long) teacherQuery.getSingleResult();

        System.out.println("\nAntalet lärare som är yngre än 40 eller är 40 år gamla: " + teacherUnderOrEqualToForty);

        askUserToContinue();
        em.close();
    }
}
