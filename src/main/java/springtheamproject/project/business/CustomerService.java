package springtheamproject.project.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springtheamproject.project.model.Customer;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers(){
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    public void add(Customer customer){
        customerRepository.save(customer);
    }

    public Customer getCustomer(String id){
        return customerRepository.findById(id).get();
    }

    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }
}
