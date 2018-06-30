package springboot.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.login.dao.AdminRepository;
import springboot.login.dao.LoginDao;
import springboot.login.dao.StudentRepository;
import springboot.login.dao.TeacherRepository;
import springboot.login.domain.Admin;
import springboot.login.domain.Student;
import springboot.login.domain.Teacher;
import springboot.login.domain.User;
import java.util.List;

/**
 * Created by huangds on 2017/10/28.
 */
@Service
public class LoginService {

    @Autowired
    private LoginDao loginDao;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;



    public boolean verifyAdmin(Admin admin){
        List<Admin> adminList = adminRepository.findByEmailAndPassword(admin.getEmail(),admin.getPassword());
        if(adminList.size()>0){
          return true;
        }else{
            return false;
        }
    }

    public boolean verifyTeacher( Teacher teacher){
        List<Teacher> teacherList = teacherRepository.findByEmailAndPassword(teacher.getEmail(),teacher.getPassword());
        if(teacherList.size()>0){
            return true;
        }else{
            return false;
        }
    }

    public boolean verifyStudent( Student student){
        List<Student> studentList = studentRepository.findByEmailAndPassword(student.getEmail(),student.getPassword());
        if(studentList.size()>0){
            return true;
        }else{
            return false;
        }
    }




}
