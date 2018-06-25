package springboot.login.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Table(name="teacher_tb")
public class Teacher {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    /* email information */
    @Column(name="email",nullable = false,length=20,unique = true)
    @NotEmpty(message="email can not be null")
    @Size(min=10,max=50)
    private String email;


    /*name information*/
    @NotEmpty(message="teacher name can not be null")
    @Size(min=2,max=20)
    @Column(nullable = false,length=20)
    private String name;

    @Column(name="password")
    private String password;

    /* course information */
    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Course> courseList;

    // phone num ,need more constraint
    @Column(name="phone_num")
    private String phone_num;









    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

/* some attribute can be key */






    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }


}
