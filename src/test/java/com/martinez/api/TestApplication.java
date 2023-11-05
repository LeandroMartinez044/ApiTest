package com.martinez.api;

import com.martinez.AppApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class TestApplication {
    private static ConfigurableApplicationContext application;

    TestApplication () {
    }


    /**
     * Runs the application, or return the already running one.
     *
     * It starts the application on a random port. To obtain the
     *
     * @return a running application, never returns null.
     */
    synchronized public static ConfigurableApplicationContext start() {
        if (application == null) {
            ArrayList<String> arguments = new ArrayList<>();
            arguments.add("--debug=false");
            arguments.add("--server.port=0");

            application = SpringApplication.run(
                            AppApplication.class, arguments.toArray(new String[0]));

            application.start();
        }

        return application;
    }
}
