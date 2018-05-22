package springtheamproject.project.business;


import org.springframework.data.jpa.repository.JpaRepository;
import springtheamproject.project.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
