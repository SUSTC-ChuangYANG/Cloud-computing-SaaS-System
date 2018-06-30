package springboot.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot.login.dao.CourseRepository;
import springboot.login.dao.ScoreRepository;
import springboot.login.dao.StudentRepository;
import springboot.login.dao.TeacherRepository;
import springboot.login.domain.Course;
import springboot.login.domain.Score;
import springboot.login.domain.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

import static springboot.login.WebSecurityConfig.SESSION_KEY;


@Controller
public class TeacherController {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;




    @RequestMapping(value = "/editscore",method=RequestMethod.POST)
    @ResponseBody
    public String editScore(HttpServletRequest request, HttpServletResponse response) {
        int score = Integer.parseInt(request.getParameter("score"));
        long student_id = Long.parseLong(request.getParameter("student_id"));
        long id = studentRepository.findBySid(student_id).getId();
        long course_id = Long.parseLong(request.getParameter("course_id"));
        Score s = scoreRepository.findByPkStudentIdAndPkCourseId(id,course_id);
        s.setScore(score);
        System.out.println("hhhhhhhhhhhh");
        scoreRepository.save(s);

        return "success";
    }

    @RequestMapping("/teacher/edit_self")
    public String editSelfInfo() {

        return "xxx";
    }

    @GetMapping(value="/teacher/my_course")
    @ResponseBody
     public List <Map<String,String>> findCourse(HttpServletRequest request){
        System.out.println("here!");
        List < Map<String,String> > result =new ArrayList<Map<String,String> >();
        HttpSession session = request.getSession();
        String email = String.valueOf(session.getAttribute(SESSION_KEY));
        List<Course> courseList = teacherRepository.findByEmail(email).getCourseList();
        for(int i= 0;i<courseList.size();i++){
            Map<String,String> map=new HashMap<>();
            Course c= courseList.get(i);
            map.put("course_id",String.valueOf(c.getId()));
            map.put("course_code",c.getCourse_code());
            map.put("course_name",c.getName());
            result.add(map);
        }



        return result;
    }

    @GetMapping(value="/teacher/my_course/{course_id}")
    public String mystudent(@PathVariable("course_id") Integer course_id,Model model) {
        List < Map<String,String> > result =new ArrayList<Map<String,String> >();
        List<Score> scoreList = scoreRepository.findByPkCourseId(course_id);
        System.out.println(scoreList.size());
        List<Student> studentList= new ArrayList<>();
        for(Score s :scoreList){
            Map<String,String> map=new HashMap<>();
            Student student = s.getStudent();
//            studentList.add(student);
            map.put("score",String.valueOf(s.getScore()));
            map.put("phone_num",student.getPhone_num());
            map.put("email",student.getEmail());
            map.put("name",student.getName());
            map.put("student_id",String.valueOf(student.getSid()));
            map.put("id",String.valueOf(student.getId()));


            result.add(map);
        }

        model.addAttribute("results",result);
        model.addAttribute("course_id",course_id);
        String course_name = courseRepository.findById(course_id).getName();
        model.addAttribute("course_name",course_name);
        return "mystudent";
    }

//    @RequestMapping(value = "/data", method = RequestMethod.POST)
//    @ResponseBody
//    public List <Map<String,String>> data() {
//        List < Map<String,String> > result =new ArrayList<Map<String,String> >();
//        List<Score> scoreList = scoreRepository.findByPkCourseId(2);
//        System.out.println(scoreList.size());
//        List<Student> studentList= new ArrayList<>();
//        for(Score s :scoreList){
//            Map<String,String> map=new HashMap<>();
//            Student student = s.getStudent();
//            map.put("student_id",String.valueOf(student.getSid()));
//            map.put("name",student.getName());
//            map.put("email",student.getEmail());
//            map.put("phone_num",student.getPhone_num());
//            map.put("score",String.valueOf(s.getScore()));
//        }
//        return result;
//    }

//    @GetMapping(value="/teacher/course_id/allStudent")
//    @ResponseBody
//    public


//    @RequestMapping("/teacher")
//    public String editScore(){
//
//        return "xxx";

//}
//    @RequestMapping("/teacher")
//    public String editScore(){
//
//        return "xxx";
//    }
}
