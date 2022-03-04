package service;

import model.Customer;

import java.util.*;

public class CustomerService {
    Map<String, Customer> mapOfCustomers = new HashMap<String, Customer>();
    private static CustomerService customerService;
    private CustomerService() {}   //使這個Constructor只能在這裏new，這樣其他物件就沒辦法直接用new來取得新的實體
    public static CustomerService getInstance() {
        // 第一次被呼叫的時候再建立物件
        if(customerService == null) {
            customerService = new CustomerService();
        }
        return customerService;
    }

    public void addCustomer(String firstName, String lastName, String email) {
        Customer customer = new Customer(firstName, lastName, email);
        mapOfCustomers.put(customer.getEmail(), customer);
    }

    public Customer getCustomer(String customerEmail) {
        return mapOfCustomers.get(customerEmail);
    }

    public Collection<Customer> getAllCustomers() {
        return mapOfCustomers.values();
    }
}