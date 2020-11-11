package org.hbrs.ia.main;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.hbrs.ia.contract.ManagePersonal;
import org.hbrs.ia.contract.Manager;
import org.hbrs.ia.model.EvaluationRecord;
import org.hbrs.ia.model.SalesMan;

import java.util.*;

public class Main {         /*Just testing out DB-features.*/
    public static void main(String[] args) {
        //TODO: GUI zum abfragen: "Was willst du tun".
        //TODO: In Main einbinden und Main bauen.
        ManagePersonal manager = new Manager();
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Welcome to Mongo-DB Client. What do you want to do?");
            System.out.println("Enter the key/number of the task you want to do.");
            System.out.println("[1] Look up a Salesman");
            System.out.println("[2]");
            System.out.println("[3]");
            System.out.println("[3] Exit");
            String taskToDo = input.nextLine();

            switch(taskToDo) {
                case "1":
                    String sid = input.nextLine();
                    SalesMan pulled = manager.readSalesMan(Integer.valueOf(sid));
                    System.out.println("ID: "+pulled.getId());
                    System.out.println("Vorname: "+pulled.getFirstname());
                    System.out.println("Nachname: "+pulled.getLastname());
                    break;

                case "3":
                    return;
                default:
                    System.out.println("Bro komm schon. Falscher Input.");
            }

        }



        /*ManagePersonal manager = new Manager();
        manager.dropSalesMen();
        SalesMan testPerson = new SalesMan("steve", "bratan", 12);
        SalesMan testPerson2 = new SalesMan("steve", "alter", 1234);
        SalesMan testPerson3 = new SalesMan("yep", "brate", 1265);
        // ... now storing the object
        manager.createSalesMan(testPerson);
        manager.createSalesMan(testPerson2);
        manager.createSalesMan(testPerson3);*/

    }
}
