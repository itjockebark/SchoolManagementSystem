package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

import static com.company.UserInputManagement.convertStringToLocalDate;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private int studentId;

    private String name;
    private LocalDate birthdate;
    private double age;

    @ManyToOne
    private Education education;

    public Student() {
    }

    public Student(String name, String birthdate) {
        this.name = name;
        LocalDate studentBirthdate = convertStringToLocalDate(birthdate);
        this.birthdate = studentBirthdate;
        this.age = getAge();
    }

    public double getAge() {
        LocalDate age = LocalDate.now();
        Period periodBetween = Period.between(birthdate, age);

        return periodBetween.getYears();
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public void setBirthdate(String birthdate) {
        LocalDate studentBirthdate = convertStringToLocalDate(birthdate);
        this.birthdate = studentBirthdate;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "Student-ID=" + studentId +
                ", Namn='" + name + '\'' +
                ", Födelsedatum=" + birthdate + '\'' +
                ", Ålder=" + getAge();
    }
}
