package springboot.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot.login.WebSecurityConfig;
import springboot.login.dao.AdminRepository;
import springboot.login.domain.Admin;
import springboot.login.domain.Student;
import springboot.login.domain.Teacher;
import springboot.login.domain.User;
import springboot.login.service.LoginService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huangds on 2017/10/24.
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;


    @GetMapping("/")
    public String index(@SessionAttribute(WebSecurityConfig.SESSION_KEY)String account,Model model){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/mainpage")
    public String mainpage(){
        return "mainpage";
    }

    @PostMapping("/loginVerify")
    public String loginVerify(String password, String email,Integer login_as,HttpSession session){

          boolean verify = false;
           //admin
          if(login_as==0){
              Admin admin = new Admin();
              admin.setEmail(email);
              admin.setPassword(password);
              verify = loginService.verifyAdmin(admin);
           //teacher
          }else if(login_as==1){
              Teacher teacher = new Teacher();
              teacher.setEmail(email);
              teacher.setPassword(password);
              verify = loginService.verifyTeacher(teacher);

          // student
          }else{
              Student student = new Student();
              student.setEmail(email);
              student.setPassword(password);
              verify = loginService.verifyStudent(student);
          }

        if (verify) {
            session.setAttribute(WebSecurityConfig.SESSION_KEY, email);
            if(login_as==0){
                session.setAttribute(WebSecurityConfig.SESSION_ROLE,"admin");
                return "index_admin";
            }else if(login_as==1){
                session.setAttribute(WebSecurityConfig.SESSION_ROLE,"teacher");
                return "index_teacher";
            }else if(login_as==2){
                session.setAttribute(WebSecurityConfig.SESSION_ROLE,"student");
                return "index_student";
            }else{
                return "redirect:/login";
            }

        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute(WebSecurityConfig.SESSION_KEY);
        return "mainpage";
    }
}
