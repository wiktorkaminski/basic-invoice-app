package wiktorkaminski.basicinvoiceapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("wiktorkaminski")
public class BasicInvoiceApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BasicInvoiceApp.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BasicInvoiceApp.class, args);


    }

}
