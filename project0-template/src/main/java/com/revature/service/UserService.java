package com.revature.service;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.models.*;

import java.util.List;

public class UserService {

    private AdminService adminService = new AdminService();
    private EmployeeService employeeService = new EmployeeService();
    private CustomerService customerService = new CustomerService();
    private UserDao userDao = new UserDaoImpl();

    public Customer createNewCustomer(String email, String password, String first, String last, UserType type){
        Customer customer = customerService.createNewCustomer(email, password, first, last, type);
        return customer;
    }

    public Employee createNewEmployee(String first, String last){
        Employee employee = employeeService.createNewEmployee(first, last);
        return employee;
    }

    public Admin createNewAdmin(String first, String last){
        Admin admin = adminService.createNewAdmin(first, last);
        return admin;
    }

    public boolean createUser(User user){
        return userDao.createUser(user);
    }

    public List<User> getAll() {
        return userDao.getAll();
    }

    public User getByUserAndPass(String username, String password) {
        return userDao.getByEmailAndPassword(username, password);
    }

    public User getById(int id) {
        return userDao.getById(id);
    }

    public boolean update(User updatedUser) {
        return userDao.update(updatedUser);
    }

    public boolean deleteUserById(int id) {
        return userDao.deleteById(id);
    }
}
