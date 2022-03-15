package com.company;

import entity.Education;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.InputMismatchException;

import static com.company.Utilities.*;

public class UserInputManagement {

    public static int askAboutTeacherId() {
        System.out.print("\nLärar-ID: ");
        return userInputInt = intScanner();
    }

    public static int askAboutStudentId() {
        System.out.print("\nStudent-ID: ");
        return userInputInt = intScanner();
    }

    public static String askAboutName() {
        System.out.print("\nNamn: ");
        return userInputString = stringScanner();
    }

    public static String askAboutBirthdate() {
        System.out.print("\nFödelsedatum yyyy-mm-dd: ");
        return userInputString = stringScanner();
    }

    public static String askAboutEducationId() {
        System.out.print("\nUtbildnings-ID: ");
        return userInputString = stringScanner();
    }

    public static String askAboutStartDate() {
        System.out.print("\nStartdatum yyyy-mm-dd: ");
        return userInputString = stringScanner();
    }

    public static String askAboutCourseId() {
        System.out.print("\nKurs-ID: ");
        return userInputString = stringScanner();
    }

    public static String stringScanner() {
        return sc.nextLine();
    }

    public static int intScanner() {
        int number = -1;
        wrongUserInput = true;
        while (wrongUserInput) {
            try {
                number = sc.nextInt();
                wrongUserInput = false;
            } catch (InputMismatchException exception) {
                System.out.print("""                						
                        Fel inmatning, det går endast att skriva in nummer!
                        Ange nummer:""");
            } finally {
                stringScanner();
            }
        }
        return number;
    }

    public static void setConnectedTeacherToNull(int newId) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<Education> educationTypedQuery = em.createNamedQuery("teacher.findTeacherId", Education.class);
            educationTypedQuery.setParameter("teacherId", newId).getSingleResult().setTeacher(null);
            em.getTransaction().commit();
        }catch (Exception exception) {}
        em.close();
    }

    public static LocalDate convertStringToLocalDate(String birthdate) {
        while (true) {
            try {
                LocalDate dateTime = LocalDate.parse(birthdate);
                return dateTime;
            } catch (Exception exception) {
                displayWrongInputText();
                birthdate = askAboutBirthdate();
            }
        }
    }

    public static void askUserToContinue() {
        System.out.print("\nKlicka ENTER för att fortsätta");
        stringScanner();
    }

    public static void displayWrongInputText() {
        System.out.println("\nFelinmatning, var god försök igen!");
        askUserToContinue();
    }
}

