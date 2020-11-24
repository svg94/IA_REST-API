package org.hbrs.ia.contract.rest;

import org.hbrs.ia.contract.ManagePersonal;
import org.hbrs.ia.contract.Manager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApplication {
    protected static ManagePersonal manager = new Manager();
    public static void main(String[] args){

        SpringApplication.run(RestApplication.class, args);
    }
}
