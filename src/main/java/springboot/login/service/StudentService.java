package springboot.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import springboot.login.dao.StudentRepository;
import springboot.login.domain.Student;

public class StudentService {
    @Autowired
    public StudentRepository studentRepository;


    /* update student */
    public void edit(Student student){
        studentRepository.save(student);
    }

    public void save(Student student){
        studentRepository.save(student);
    }


    public Student findStudentById(long id) {
        return studentRepository.findById(id);
    }






}
