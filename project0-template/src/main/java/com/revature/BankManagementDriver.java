package com.revature;

import com.revature.dao.UserDao;
import com.revature.models.Customer;
import com.revature.service.CustomerService;
import com.revature.util.LoggingSingleton;

public class BankManagementDriver {

    public static void main(String[] args){
        LoggingSingleton logger = LoggingSingleton.getLogger();

        JavalinApp app = new JavalinApp();
        app.start(8080);
    }
}
