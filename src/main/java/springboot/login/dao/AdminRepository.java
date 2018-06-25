package springboot.login.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.login.domain.Admin;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin , Long> {

    List<Admin> findByEmailAndPassword(String email, String password);
}

