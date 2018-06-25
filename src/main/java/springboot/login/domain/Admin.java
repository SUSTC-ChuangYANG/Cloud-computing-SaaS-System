package springboot.login.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="admin_tb")
public class Admin {
    @Id
    @Column(name = "adminId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="admin_name")
    private String name;




    /* email information */
    @Column(name="email",nullable = false,length=20,unique = true)
    @NotEmpty(message="email can not be null")
    @Size(min=8,max=50)
    private String email;

    @Column(name="password")
    private String password;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
