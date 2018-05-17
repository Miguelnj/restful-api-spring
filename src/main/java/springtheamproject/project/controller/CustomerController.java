package springtheamproject.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springtheamproject.project.business.CustomerService;
import springtheamproject.project.model.Customer;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @RequestMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable String id){
        return customerService.getCustomer(id);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public void addCustomer(@RequestBody Customer customer){
        customerService.add(customer);
    }

    @RequestMapping(value = "customers", method = RequestMethod.PUT)
    public void updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
    }

    @RequestMapping(value = "customers/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable String id){
        customerService.deleteCustomer(id);
    }
}
