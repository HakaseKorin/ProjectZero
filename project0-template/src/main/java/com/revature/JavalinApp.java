package com.revature;

import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.path;

public class JavalinApp {

    private Javalin app = Javalin.create().routes(()->{
    });

    public void start(int port){app.start(port);}

}
