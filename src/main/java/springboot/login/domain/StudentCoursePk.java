package springboot.login.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class StudentCoursePk implements Serializable{
    private long studentId;
    private long courseId;

    public StudentCoursePk(long studentId, long courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public StudentCoursePk() {
    }
}
