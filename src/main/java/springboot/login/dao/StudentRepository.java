package springboot.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import springboot.login.domain.Course;
import springboot.login.domain.Student;
import springboot.login.domain.Teacher;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student , Long> {
    Student findById(long id);
    Student findByEmail(String email);
    Long deleteBySid(long id);
    List<Student> findByEmailAndPassword(String email, String password);
    Student findBySid(long sid);
//    List<Course> findCourseByStudent(long id);

}
