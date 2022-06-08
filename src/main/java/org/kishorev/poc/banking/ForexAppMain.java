package org.kishorev.poc.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ForexAppMain
{
    public static void main( String[] args )
    {
        SpringApplication app = new SpringApplication(ForexAppMain.class);
        app.run(args);

    }
}
