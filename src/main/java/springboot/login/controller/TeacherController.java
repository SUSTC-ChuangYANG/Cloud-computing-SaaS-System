package springboot.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springboot.login.dao.CourseRepository;
import springboot.login.dao.ScoreRepository;
import springboot.login.dao.StudentRepository;
import springboot.login.domain.Course;
import springboot.login.domain.Score;
import springboot.login.domain.Student;

import java.util.*;


@Controller
public class TeacherController {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ScoreRepository scoreRepository;
    @Autowired
    private StudentRepository studentRepository;


    @RequestMapping("/teacher/edit_score")
    public String editScore() {

        return "xxx";
    }

    @RequestMapping("/teacher/edit_self")
    public String editSelfInfo() {

        return "xxx";
    }

    @GetMapping(value="/teacher/my_course")
    @ResponseBody
     public List <Map<String,String>> findCourse(){

        List < Map<String,String> > result =new ArrayList<Map<String,String> >();

        List<Course> courseList = courseRepository.findAll();
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
    @ResponseBody
    public List<Student> findCourseStudent(@PathVariable("course_id") Integer course_id){
         System.out.println(course_id);
        List<Score> scoreList = scoreRepository.findByPkCourseId(2);
        System.out.println(scoreList.size());
        List<Student> studentList= new ArrayList<>();
        for(Score s :scoreList){
            studentList.add(s.getStudent());
        }

        return studentList;
    }

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
