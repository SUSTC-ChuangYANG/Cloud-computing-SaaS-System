package springboot.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springboot.login.domain.Student;
import springboot.login.service.StudentService;

public class StudentContorller {
    @Autowired
    private StudentService studentService;





    @RequestMapping("/edit")
    public String edit(Student student){

        studentService.edit(student);
        return "student/edit";  // to student edit html
    }

    /* edit a student's information */
    // this function is invoke by student self ,send it self to edit page
    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id) {
        Student student=studentService.findStudentById(id);
        model.addAttribute("student", student);
        return "student/studentEdit";
    }


    @RequestMapping("/studentInfo")
    public String showStudentInfo(Model model,Long id){
        Student student=studentService.findStudentById(id);
        model.addAttribute("student", student);
        return "student/studentInfo";
    }

//    @RequestMapping("/courseInfo")
//    public String showCourseList(Model model,Long id){
//
//    }





}
