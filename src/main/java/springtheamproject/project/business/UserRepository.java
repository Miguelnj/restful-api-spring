package springtheamproject.project.business;


import org.springframework.data.jpa.repository.JpaRepository;
import springtheamproject.project.model.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
