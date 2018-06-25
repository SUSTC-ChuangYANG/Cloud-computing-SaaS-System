package springboot.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import springboot.login.dao.TeacherRepository;

public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;


}
