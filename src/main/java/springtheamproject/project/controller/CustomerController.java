package springtheamproject.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springtheamproject.project.service.CustomerService;
import springtheamproject.project.model.Customer;

import java.util.List;

@RestController
public class CustomerController {

    public static final String customerPath = "/customers";
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(customerPath)
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @RequestMapping(customerPath + "/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return customerService.getCustomer(id);
    }

    @RequestMapping(value = customerPath, method = RequestMethod.POST)
    public void addCustomer(@RequestBody Customer customer){
        customerService.add(customer);
    }

    @RequestMapping(value = customerPath, method = RequestMethod.PUT)
    public void updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
    }

    @RequestMapping(value = customerPath + "/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
    }
}
