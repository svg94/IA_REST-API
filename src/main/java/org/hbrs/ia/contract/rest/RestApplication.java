package org.hbrs.ia.contract.rest;

import org.hbrs.ia.contract.ManagePersonal;
import org.hbrs.ia.contract.Manager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApplication {
    public static void main(String[] args){
        //ManagePersonal manager = new Manager();
        SpringApplication.run(RestApplication.class, args);
    }
}
