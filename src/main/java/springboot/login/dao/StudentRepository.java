package springboot.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import springboot.login.domain.Course;
import springboot.login.domain.Student;
import springboot.login.domain.Teacher;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student , Long> {
    Student findById(long id);
    Long deleteById(long id);
    List<Student> findByEmailAndPassword(String email, String password);
//    List<Course> findCourseByStudent(long id);

}
