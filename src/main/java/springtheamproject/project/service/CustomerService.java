package springtheamproject.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import springtheamproject.project.model.Customer;
import springtheamproject.project.repository.CustomerRepository;
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
        MyUserPrincipal user = (MyUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
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

        customer.setCreatedBy(getCustomer(customer.getId()).getCreatedBy());
        MyUserPrincipal user = (MyUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        customer.setLastUserWhoEdited(user.getUsername());
        customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
