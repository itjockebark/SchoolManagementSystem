package com.company;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Utilities {

    static Scanner sc = new Scanner(System.in);

    static boolean loopProgram = true;
    static boolean wrongUserInput = true;

    static int userInputInt;
    static String userInputString;

    static int teacherId;
    static int studentId;
    static String name;
    static String birthdate;
    static String educationId;
    static String startDate;
    static String courseId;

    static AddAndConnectManagement ACManagement = new AddAndConnectManagement();
    static RemoveAndDisconnectManagement removeManagement = new RemoveAndDisconnectManagement();
    static PrintManagement printManagement = new PrintManagement();
    static SearchManagement searchManagement = new SearchManagement();
    static UpdateManagement updateManagement = new UpdateManagement();
    static SortManagement sortManagement = new SortManagement();
    static StatisticsManagement statisticsManagement = new StatisticsManagement();


    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");

}
