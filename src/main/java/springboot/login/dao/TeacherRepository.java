package springboot.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import springboot.login.domain.Student;
import springboot.login.domain.Teacher;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    Teacher findById(long id);
    List<Teacher> findByEmailAndPassword(String email, String password);
    Teacher findByEmail(String email);
}
