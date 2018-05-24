package springtheamproject.project.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import springtheamproject.project.model.Customer;
import springtheamproject.project.security.MyUserPrincipal;

import java.util.ArrayList;
import java.util.List;


@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers(){
        return new ArrayList<>(customerRepository.findAll());
    }

    public void add(Customer customer){
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        customer.setLastUserWhoEdited(user.getUsername());
        customer.setCreatedBy(user.getUsername());
        customer.setNullId();
        customerRepository.save(customer);
    }

    public Customer getCustomer(Long id){
        try{
            return customerRepository.findById(id).get();
        }catch(Exception notFoundException){
            return null;
        }
    }

    public void updateCustomer(Customer customer) {

        if(getCustomer(customer.getId()) == null) return;

        MyUserPrincipal user = (MyUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        customer.setLastUserWhoEdited(user.getUsername());

        customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
