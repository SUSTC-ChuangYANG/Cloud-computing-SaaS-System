package springboot.login.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="course_tb")
public class Course implements Serializable {

    @Id
    @Column(name = "courseId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;



    /* course name information */
    @Column(name = "course_code",unique = true)
    private String course_code;  // for example, cs302

    /* course name information */
    @Column(name = "course_name")

    private String name;

    /* course size information */
    @Column(name = "course_size")
    private int size;

    /* course's teacher information */
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH},optional = false)
    @JoinColumn(name="teacher_id")
    public Teacher teacher;


    /* course's students information */
    @OneToMany(mappedBy = "course",fetch = FetchType.EAGER)
    private List<Score> scoreList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }
}
