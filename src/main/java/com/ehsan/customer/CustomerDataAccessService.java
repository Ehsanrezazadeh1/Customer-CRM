package com.ehsan.customer;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fake")
public class CustomerDataAccessService implements CustomerDao{

    public static List<Customer> customers;

    static {
        customers = new ArrayList<>();
        Customer alex = new Customer(1,"alex","alex@test.com", 25);
        Customer jamila = new Customer(2,"jamila","jamila@test.com", 22);
        Customer ehsan = new Customer(3,"ehsan","ehsan@test.com", 22);
        customers.add(alex);
        customers.add(jamila);
        customers.add(ehsan);
    }
    @Override
    public List<Customer> selectAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customers.stream().filter(c -> c.getId().equals(id)).findFirst();
    }
}
