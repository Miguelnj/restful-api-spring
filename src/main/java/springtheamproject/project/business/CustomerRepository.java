package springtheamproject.project.business;


import org.springframework.data.repository.CrudRepository;
import springtheamproject.project.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer,String> {
}
