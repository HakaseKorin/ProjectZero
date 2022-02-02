package com.revature;

import com.revature.models.Customer;
import com.revature.service.UserService;
import com.revature.util.LoggingSingleton;
import io.javalin.Javalin;

public class RestaurantDeliveryManagementDriver {

    public static void main(String[] args){
        LoggingSingleton logger = LoggingSingleton.getLogger();
        //logger.setWriteToFile(true);


        Javalin app = Javalin.create().start();

        UserService userService = new UserService();

        app.get("/", ctx -> ctx.result("Hello World"));
        app.post("/users", ctx -> {
            Customer customer = ctx.bodyAsClass(Customer.class);
            boolean success = userService.createCustomer(customer);

            if(success)
                ctx.status(201);
            else
                ctx.status(400);

        });
        //JavalinApp app = new JavalinApp();
        //app.start(8080);
    }

}
