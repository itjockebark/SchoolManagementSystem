package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static com.company.UserInputManagement.convertStringToLocalDate;

@NamedQuery(name = "teacher.findAll", query = "SELECT t FROM Teacher t")
@NamedQuery(name = "student.findAll", query = "SELECT s FROM Student s")
@NamedQuery(name = "education.findAll", query = "SELECT e FROM Education e")
@NamedQuery(name = "course.findAll", query= "SELECT c FROM Course c")
@NamedQuery(name = "teacher.findById", query = "SELECT t FROM Teacher t WHERE t.teacherId =:teacherId")
@NamedQuery(name = "student.findById", query = "SELECT s FROM Student s WHERE s.studentId =:studentId")
@NamedQuery(name = "education.findById", query = "SELECT e FROM Education e WHERE e.educationId =:educationId")
@NamedQuery(name = "course.findById", query = "SELECT c FROM Course c WHERE c.courseId =:courseId")
@NamedQuery(name = "teacher.findByName", query = "SELECT t FROM Teacher t WHERE t.name =:name")
@NamedQuery(name = "student.findByName", query = "SELECT s FROM Student s WHERE s.name =:name")
@NamedQuery(name = "education.findByName", query = "SELECT e FROM Education e WHERE e.name =:name")
@NamedQuery(name = "course.findByName", query = "SELECT c FROM Course c WHERE c.name =:name")
@NamedQuery(name = "teacher.findTeacherId", query = "SELECT e FROM Education e WHERE e.teacher.teacherId =:teacherId")
@NamedQuery(name = "teacher.sortByNameASC", query = "SELECT t FROM Teacher t ORDER BY t.name ASC")
@NamedQuery(name = "student.sortByBirthdateASC", query = "SELECT s FROM Student s ORDER BY s.birthdate ASC")
@NamedQuery(name = "education.sortByEducationIdASC", query = "SELECT e FROM Education e ORDER BY e.educationId ASC")
@NamedQuery(name = "education.sortByNameASC", query = "SELECT e FROM Education e ORDER BY e.name ASC")
@NamedQuery(name = "course.sortByNameASC", query = "SELECT c FROM Course c ORDER BY c.name ASC")
@NamedQuery(name = "teacher.sortByNameDESC", query = "SELECT t FROM Teacher t ORDER BY t.name DESC")
@NamedQuery(name = "teacher.sortByBirthdateDESC", query = "SELECT t FROM Teacher t ORDER by t.birthdate DESC")
@NamedQuery(name = "student.sortByStudentIdDESC", query = "SELECT s FROM Student s ORDER BY s.studentId DESC")
@NamedQuery(name = "education.sortByEducationIdDESC", query = "SELECT e FROM Education e ORDER BY e.educationId DESC")
@NamedQuery(name = "course.sortByNameDESC", query = "SELECT c FROM Course c ORDER BY c.name DESC")
@NamedQuery(name = "teacher.total", query = "SELECT COUNT (t) FROM Teacher t")
@NamedQuery(name = "student.total", query = "SELECT COUNT (s) FROM Student s")
@NamedQuery(name = "education.total", query = "SELECT COUNT (e) FROM Education e")
@NamedQuery(name = "course.total", query = "SELECT COUNT (c) FROM Course c")
@NamedQuery(name = "teacher.minAge", query = "SELECT MIN(t.age) FROM Teacher t")
@NamedQuery(name = "teacher.maxAge", query = "SELECT MAX(t.age) FROM Teacher t")
@NamedQuery(name = "teacher.averageAge", query = "SELECT AVG(t.age) FROM Teacher t")
@NamedQuery(name = "student.minAge", query = "SELECT MIN(s.age) FROM Student s")
@NamedQuery(name = "student.maxAge", query = "SELECT MAX(s.age) FROM Student s")
@NamedQuery(name = "student.averageAge", query = "SELECT AVG(s.age) FROM Student s")
@NamedQuery(name = "teacher.aboveForty", query = "SELECT COUNT(t) FROM Teacher t WHERE t.age > 40")
@NamedQuery(name = "teacher.underOrEqualToForty", query = "SELECT COUNT(t) FROM Teacher t WHERE t.age <= 40")
@NamedQuery(name = "student.aboveThirty", query = "SELECT COUNT(s) FROM Student s WHERE s.age > 30")
@NamedQuery(name = "student.underOrEqualToThirty", query = "SELECT COUNT(s) FROM Student s WHERE s.age < 30")
@NamedQuery(name = "education.startDateAfter20200714", query = "SELECT COUNT(e) FROM Education e WHERE e.startDate >= '2020-07-14'")
@NamedQuery(name = "education.startDateBefore20200714", query = "SELECT COUNT(e) FROM Education e WHERE e.startDate < '2020-07-14'")
@NamedQuery(name = "education.durationLongerThanTwelveMonths", query = "SELECT COUNT(e) FROM Education e WHERE e.educationDuration > 12")
@NamedQuery(name = "education.durationShorterThanThirteenMonths", query = "SELECT COUNT(e) FROM Education e WHERE e.educationDuration <= 12")

@Entity
public class Education {
    @Id
    private String educationId;

    private String name;
    private LocalDate startDate;
    private double educationDuration;

    @OneToOne
    private Teacher teacher;

    @OneToMany(mappedBy = "Education")
    List<Student> students = new ArrayList<>();

    @ManyToMany(mappedBy = "educations")
    List<Course> courses = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        student.setEducation(this);
    }

    public void removeStudent(Student student) {
        students.remove(student);
        student.setEducation(null);
    }

    public void addCourse(Course course) {
        courses.add(course);
        course.getEducations().add(this);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
        course.getEducations().remove(this);
    }

    public Education() {
    }


    public Education(String educationId, String name, String startDate) {
        this.educationId = educationId;
        this.name = name;

        LocalDate educationStartDate = convertStringToLocalDate(startDate);
        this.startDate = educationStartDate;
        this.educationDuration = getEducationDuration();
    }

    public double getEducationDuration() {
        LocalDate educationDuration = LocalDate.now();
        return ChronoUnit.MONTHS.between(startDate, educationDuration);
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setStartDate(String startDate) {
        LocalDate educationStartDate = convertStringToLocalDate(startDate);
        this.startDate = educationStartDate;
    }

    public void setEducationDuration(double educationDuration) {
        this.educationDuration = educationDuration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEducationId(String educationId) {
        this.educationId = educationId;
    }

    public String getEducationId() {
        return educationId;
    }

    @Override
    public String toString() {
        return  "Utbildnings-ID='" + educationId + '\'' +
                ", Namn'" + name + '\'' +
                ", Startdatum=" + startDate +
                ", Utbildningens varaktighet=" + getEducationDuration() + " månader";
    }
}
