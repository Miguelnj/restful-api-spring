package springtheamproject.project.business;


import org.springframework.data.repository.CrudRepository;
import springtheamproject.project.model.User;

public interface UserRepository extends CrudRepository<User,String> {
}
