package springboot.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springboot.login.dao.CourseRepository;
import springboot.login.domain.Course;

import java.util.*;


@Controller
public class TeacherController {

    @Autowired
    private CourseRepository courseRepository;


    @RequestMapping("/teacher/edit_score")
    public String editScore() {

        return "xxx";
    }

    @RequestMapping("/teacher/edit_self")
    public String editSelfInfo() {

        return "xxx";
    }

    @GetMapping(value="/teacher/{teacher_id}/my_course")
    @ResponseBody
     public List <Map<String,String>> findCourse(){

        List < Map<String,String> > result =new ArrayList<Map<String,String> >();

        List<Course> courseList = courseRepository.findAll();
        for(int i= 0;i<courseList.size();i++){
            Map<String,String> map=new HashMap<>();
            Course c= courseList.get(i);
            map.put("course_code",c.getCourse_code());
            map.put("course_name",c.getName());
            result.add(map);
        }



        return result;
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
