package springboot.login.domain;

import javax.persistence.*;

@Entity
//@IdClass(StudentCoursePk.class)

public class Score {
    @EmbeddedId
    private StudentCoursePk pk;
//
//    @Id
//    @Column(name="studentId",insertable=false, updatable=false)
//    private long studentId;
//
//    @Id
//    @Column(name="courseId",insertable=false, updatable=false)
//    private long courseId;

    @Column(name="score")
    private int score;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="studentId",insertable=false, updatable=false)
    private Student student;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name="courseId",insertable=false, updatable=false)
    private Course course;

    public Score(StudentCoursePk pk){
        this.pk=pk;
//        this.courseId=courseId;
//        this.studentId=studentId;

       }
    public StudentCoursePk getPk() {
        return pk;
    }public void setPk(StudentCoursePk pk) {
        this.pk = pk;
    }public int getScore() {
        return score;
    }public void setScore(int score) {
        this.score = score;
    }public Student getStudent() {
        return student;
    }public void setStudent(Student student) {
        this.student = student;
    }public Course getCourse() {
        return course;
    }public void setCourse(Course course) {
        this.course = course;
    }
    public Score() {
    }
}
