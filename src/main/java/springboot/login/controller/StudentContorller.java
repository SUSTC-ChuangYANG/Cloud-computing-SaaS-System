package springboot.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.login.WebSecurityConfig;
import springboot.login.dao.CourseRepository;
import springboot.login.dao.ScoreRepository;
import springboot.login.dao.StudentRepository;
import springboot.login.domain.Course;
import springboot.login.domain.Score;
import springboot.login.domain.Student;
import springboot.login.service.StudentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static springboot.login.WebSecurityConfig.SESSION_KEY;


@Controller
public class StudentContorller {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private StudentRepository studentRepository;





    @GetMapping(value="/student/myscore")
    @ResponseBody
    public List<Map<String,String>> getScore(HttpServletRequest request){

        List < Map<String,String> > result =new ArrayList<Map<String,String> >();
        HttpSession session = request.getSession();
        String email = String.valueOf(session.getAttribute(SESSION_KEY));

        System.out.println(email);

        Student student = studentRepository.findByEmail(email);
        List<Score> scoreList =scoreRepository.findByPkStudentId(student.getId());

        for(int i= 0;i<scoreList.size();i++){
            Map<String,String> map=new HashMap<>();
            Score score = scoreList.get(i);
            Course c = score.getCourse();
            c.getTeacher().getName();
            map.put("course_id",String.valueOf(c.getId()));
            map.put("course_code",c.getCourse_code());
            map.put("course_name",c.getName());
            map.put("teacher_name", c.getTeacher().getName());
            map.put("score",String.valueOf(score.getScore()));
            result.add(map);
        }



        return result;
    }

//    @RequestMapping("/courseInfo")
//    public String showCourseList(Model model,Long id){
//
//    }





}
