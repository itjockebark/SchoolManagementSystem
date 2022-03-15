package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    private String courseId;

    private String name;

    @ManyToMany
    List<Education> educations = new ArrayList<>();

    public Course() {
    }

    public Course(String courseId, String name) {
        this.courseId = courseId;
        this.name = name;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }


    @Override
    public String toString() {
        return "Kurs-ID='" + courseId + '\'' +
                ", Namn='" + name;
    }
}
