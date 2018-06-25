package springboot.login.domain;

import com.sun.org.glassfish.gmbal.ManagedAttribute;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="student_tb")
public class Student implements Serializable {

    @Id
    @Column(name = "studentId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;



    // student card number
    @Column(name="sid",nullable = false)
    private long sid;


    @Column(name="student_name")
    private String name;




    /* email information */
    @Column(name="email",nullable = false,length=20,unique = true)
    @NotEmpty(message="email can not be null")
    @Size(min=8,max=50)
    private String email;

    // phone num ,need more constraint
    @Column(name="phone_num")
    private String phone_num;

    @Column(name="password")
    private String password;

    /* student's courses information */
    @OneToMany(mappedBy = "student",fetch = FetchType.EAGER)
    private List<Score> scoreList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Score> getScoreList() {
        return scoreList;
    }

    public void setScoreList(List<Score> scoreList) {
        this.scoreList = scoreList;
    }

    public String toString(){
        return this.name+" "+this.email+" "+this.phone_num+" "+this.sid;
    }

}
