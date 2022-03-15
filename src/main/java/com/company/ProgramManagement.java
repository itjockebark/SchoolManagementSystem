package com.company;

import static com.company.UI.*;
import static com.company.UserInputManagement.*;
import static com.company.Utilities.*;

public class ProgramManagement {

    public static void mainProgram() {
        switch (mainMenu()) {
            case 1 -> addAndConnectManagementProgram();
            case 2 -> removeAndDisconnectProgram();
            case 3 -> updateProgram();
            case 4 -> searchProgram();
            case 5 -> printProgram();
            case 6 -> sortProgram();
            case 7 -> statisticsProgram();
            case 0 -> {
                loopProgram = false;
                System.out.println("Programmet är nu avslutat!");
            }
            default -> displayWrongInputText();
        }
    }

    public static void addAndConnectManagementProgram() {
        switch (addAndConnectManagementMenu()) {
            case 1 -> addProgram();
            case 2 -> connectProgram();
            case 3 -> addAndConnectProgram();
            case 4 -> ACManagement.addFalseEntities();
            case 0 -> {}
            default -> displayWrongInputText();
        }
    }

    public static void addProgram() {
        switch (addMenu()) {
            case 1 -> ACManagement.addTeacher();
            case 2 -> ACManagement.addStudent();
            case 3 -> ACManagement.addEducation();
            case 4 -> ACManagement.addCourse();
            case 0 -> {}
            default -> displayWrongInputText();
        }
    }

    public static void connectProgram() {
        switch (connectMenu()) {
            case 1 -> ACManagement.connectTeacherToEducation();
            case 2 -> ACManagement.connectStudentToEducation();
            case 3 -> ACManagement.connectCourseToEducation();
            case 0 -> {}
            default -> displayWrongInputText();
        }
    }

    public static void addAndConnectProgram() {
        switch (addAndConnectMenu()) {
            case 1 -> ACManagement.addNewTeacherToExistingEducation();
            case 2 -> ACManagement.addNewStudentToExistingEducation();
            case 3 -> ACManagement.addNewCourseToExistingEducation();
            case 0 -> {}
            default -> displayWrongInputText();
        }
    }

    public static void removeAndDisconnectProgram() {
        switch (removeAndDisconnectMenu()) {
            case 1 -> removeProgram();
            case 2 -> disconnectProgram();
            case 0 -> {}
            default -> displayWrongInputText();
        }
    }

    public static void removeProgram() {
        switch (removeMenu()) {
            case 1 -> removeByIdProgram();
            case 2 -> removeByNameProgram();
            case 0 -> {}
            default -> displayWrongInputText();
        }
    }

    public static void removeByIdProgram() {
        switch (removeByIdMenu()) {
            case 1 -> removeManagement.removeTeacherById();
            case 2 -> removeManagement.removeStudentById();
            case 3 -> removeManagement.removeEducationById();
            case 4 -> removeManagement.removeCourseById();
            case 0 -> {}
            default -> displayWrongInputText();
        }
    }

    private static void removeByNameProgram() {
        switch (removeByNameMenu()) {
            case 1 -> removeManagement.removeTeacherByName();
            case 2 -> removeManagement.removeStudentByName();
            case 3 -> removeManagement.removeEducationByName();
            case 4 -> removeManagement.removeCourseByName();
            case 0 -> {}
            default -> displayWrongInputText();
        }
    }

    public static void disconnectProgram() {
        switch (disconnectMenu()) {
            case 1 -> removeManagement.disconnectTeacherFromEducation();
            case 2 -> removeManagement.disconnectStudentFromEducation();
            case 3 -> removeManagement.disconnectCourseFomEducation();
            case 0 -> {}
            default -> displayWrongInputText();
        }
    }

    public static void updateProgram() {
        switch (updateMenu()) {
            case 1 -> updateManagement.updateTeacherName();
            case 2 -> updateManagement.updateTeacherBirthdate();
            case 3 -> updateManagement.updateStudentName();
            case 4 -> updateManagement.updateStudentBirthdate();
            case 5 -> updateManagement.updateEducationName();
            case 6 -> updateManagement.updateEducationStartDate();
            case 7 -> updateManagement.updateCourseName();
            case 0 -> {}
            default -> displayWrongInputText();
        }
    }

    public static void searchProgram() {
        switch (searchMenu()) {
            case 1 -> searchByIdProgram();
            case 2 -> searchByNameProgram();
            case 0 -> {}
            default -> displayWrongInputText();
        }
    }

    public static void searchByIdProgram() {
        switch (searchByIdMenu()) {
            case 1 -> {
                teacherId = askAboutTeacherId();
                System.out.println("\n" + searchManagement.searchTeacherByTeacherId(teacherId));
                askUserToContinue();
            }
            case 2 -> {
                studentId = askAboutStudentId();
                System.out.println("\n" + searchManagement.searchStudentByStudentId(studentId));
                askUserToContinue();
            }
            case 3 -> {
                educationId = askAboutEducationId();
                System.out.println("\n" + searchManagement.searchEducationByEducationId(educationId));
                askUserToContinue();
            }
            case 4 -> {
                courseId = askAboutCourseId();
                System.out.println("\n" + searchManagement.searchCourseByCourseId(courseId));
                askUserToContinue();
            }
            case 0 -> {}
            default -> displayWrongInputText();
        }
    }

    public static void searchByNameProgram() {
        switch(searchByNameMenu()) {
            case 1 -> {
                name = askAboutName();
                System.out.println("\n" + searchManagement.searchTeacherByNameAndReturnInt(name));
                askUserToContinue();
            }
            case 2 -> {
                name = askAboutName();
                System.out.println("\n" + searchManagement.searchStudentByName(name));
                askUserToContinue();
            }
            case 3 -> {
                name = askAboutName();
                System.out.println("\n" + searchManagement.searchEducationByName(name));
                askUserToContinue();
            }
            case 4 -> {
                name = askAboutName();
                System.out.println("\n" + searchManagement.searchCourseByName(name));
                askUserToContinue();
            }
            case 0 -> {}
            default -> displayWrongInputText();
        }
    }


    public static void printProgram() {
        switch (printMenu()) {
            case 1 -> {
                printManagement.printAllTeachers();
                askUserToContinue();
            }
            case 2 -> {
                printManagement.printAllStudents();
                askUserToContinue();
            }
            case 3 -> {
                printManagement.printAllEducations();
                askUserToContinue();
            }
            case 4 -> {
                printManagement.printAllCourses();
                askUserToContinue();
            }
            case 0 -> {}
            default -> displayWrongInputText();
        }
    }

    public static void sortProgram() {
        switch (sortMenu()) {
            case 1 -> sortAscendingProgram();
            case 2 -> sortDescendingProgram();
            case 0 -> {}
            default -> displayWrongInputText();
        }
    }

    public static void sortAscendingProgram() {
        switch (sortAscendingMenu()) {
            case 1 -> sortManagement.sortTeacherByNameASC();
            case 2 -> sortManagement.sortStudentByBirthdateASC();
            case 3 -> sortManagement.sortEducationByEducationIdASC();
            case 4 -> sortManagement.sortEducationByNameASC();
            case 5 -> sortManagement.sortCourseByNameASC();
            case 0 -> {}
            default -> displayWrongInputText();
        }
    }

    public static void sortDescendingProgram() {
        switch (sortDescendingMenu()) {
            case 1 -> sortManagement.sortTeacherByNameDESC();
            case 2 -> sortManagement.sortTeacherByBirthdateDESC();
            case 3 -> sortManagement.sortStudentByIdDESC();
            case 4 -> sortManagement.sortEducationByEducationIdDESC();
            case 5 -> sortManagement.sortCourseByNameDESC();
            case 0 -> {}
            default -> displayWrongInputText();
        }
    }

    public static void statisticsProgram() {
        switch (statisticsMenu()) {
            case 1 -> statisticsTeacherProgram();
            case 2 -> statisticStudentProgram();
            case 3 -> statisticsEducationProgram();
            case 4 -> statisticsCourseProgram();
            case 0 -> {}
            default -> displayWrongInputText();
        }
    }

    public static void statisticsTeacherProgram() {
        switch (statisticsTeacherMenu()) {
            case 1 -> statisticsManagement.totalTeachers();
            case 2 -> statisticsManagement.minAgeTeachers();
            case 3 -> statisticsManagement.maxAgeTeachers();
            case 4 -> statisticsManagement.averageAgeTeachers();
            case 5 -> statisticsManagement.teacherAboveForty();
            case 6 -> statisticsManagement.teacherUnderOrEqualToForty();
            case 0 -> {}
            default -> displayWrongInputText();
        }
    }

    public static void statisticStudentProgram() {
        switch (statisticsStudentMenu()) {
            case 1 -> statisticsManagement.totalStudents();
            case 2 -> statisticsManagement.minAgeStudents();
            case 3 -> statisticsManagement.maxAgeStudents();
            case 4 -> statisticsManagement.averageAgeStudents();
            case 5 -> statisticsManagement.studentAboveThirty();
            case 6 -> statisticsManagement.studentUnderOrEqualToThirty();
            case 0 -> {}
            default -> displayWrongInputText();
        }
    }

    public static void statisticsEducationProgram() {
        switch (statisticsEducationMenu()) {
            case 1 -> statisticsManagement.totalEducations();
            case 2 -> statisticsManagement.durationLongerThanTwelveMonths();
            case 3 -> statisticsManagement.durationShorterTanThirteenMonths();
            case 4 -> statisticsManagement.startDateAfter();
            case 5 -> statisticsManagement.startDateBefore();
            case 0 -> {}
            default -> displayWrongInputText();
        }
    }

    public static void statisticsCourseProgram() {
        switch (statisticsCourseMenu()) {
            case 1 -> statisticsManagement.totalCourses();
            case 0 -> {}
            default -> displayWrongInputText();
        }
    }
}
