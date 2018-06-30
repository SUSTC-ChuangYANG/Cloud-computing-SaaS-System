package springboot.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.login.domain.Score;
import springboot.login.domain.StudentCoursePk;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, StudentCoursePk> {
   List<Score> findByPkStudentId(long studentId);
    List<Score> findByPkCourseId(long courseId);
    Score findByPkStudentIdAndPkCourseId(long studentId,long courseId);
}
