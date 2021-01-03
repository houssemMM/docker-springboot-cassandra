package org.springs.cassandra.controller;

import org.springs.cassandra.ResourceNotFoundException;
import org.springs.cassandra.model.Customer;
import org.springs.cassandra.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @PostMapping("/customers")
    public Customer addStudent(@RequestBody Customer customer){
        customerRepository.save(customer);
        return customer;
    }

    @GetMapping("/customers/id")
    public ResponseEntity<Customer> findById(@PathVariable("id") Integer customerId){

        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new ResourceNotFoundException("Customer not found..." + customerId));

        return ResponseEntity.ok().body(customer);
    }

    @GetMapping("/customers")
    public List<Customer> getStudents(){
        return customerRepository.findAll();
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateStudent(@PathVariable(value="id") Integer customerId, @RequestBody Customer customerDeatils){

        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new ResourceNotFoundException("Student not found..." + customerId));

        customer.setName(customerDeatils.getName());
        final Customer updatedCustomer = customerRepository.save(customer);

        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable(value="id") Integer customerId, @RequestBody Customer customerDeatils) {

        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new ResourceNotFoundException("Student not found..." + customerId));

        customerRepository.delete(customer);
        return ResponseEntity.ok().build();
    }
}
