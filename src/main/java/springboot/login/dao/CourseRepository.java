package springboot.login.dao;

import org.springframework.data.repository.CrudRepository;
import springboot.login.domain.Course;
import springboot.login.domain.Student;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {
    Course  findById(long id);
    List<Course> findByTeacherId(long id);
    List<Course> findAll();
}
