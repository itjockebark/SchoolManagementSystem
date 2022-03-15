package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

import static com.company.UserInputManagement.convertStringToLocalDate;

@Entity
public class Teacher {

    @Id
    @GeneratedValue
    private int teacherId;

    private String name;
    private LocalDate birthdate;
    private double age;

    public Teacher() {
    }

    public Teacher(String name, String birthdate) {
        this.name = name;
        LocalDate teacherBirthdate = convertStringToLocalDate(birthdate);
        this.birthdate = teacherBirthdate;
        this.age = getAge();
    }

    public double getAge() {
        LocalDate age = LocalDate.now();
        Period periodBetween = Period.between(birthdate, age);

        return periodBetween.getYears();
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
        LocalDate teacherBirthdate = convertStringToLocalDate(birthdate);
        this.birthdate = teacherBirthdate;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    @Override
    public String toString() {
        return  "Lärar-ID=" + teacherId +
                ", Namn='" + name + '\'' +
                ", Födelsedatum=" + birthdate + '\'' +
                ", Ålder=" + getAge() + " år";
    }
}
