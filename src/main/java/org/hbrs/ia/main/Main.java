package org.hbrs.ia.main;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.hbrs.ia.contract.ManagePersonal;
import org.hbrs.ia.contract.Manager;
import org.hbrs.ia.model.SalesMan;

import java.util.LinkedList;
import java.util.List;

public class Main {         /*Just testing out DB-features.*/
    public static void main(String[] args){
        //TODO: GUI zum abfragen: "Was willst du tun".
        //TODO: In Main einbinden und Main bauen.
        ManagePersonal manager = new Manager();
        manager.dropSalesMen();
        SalesMan testPerson = new SalesMan("steve","bratan",12);
        SalesMan testPerson2 = new SalesMan("steve","alter",1234);
        SalesMan testPerson3 = new SalesMan("yep","brate",1265);
        // ... now storing the object
        manager.createSalesMan(testPerson);
        manager.createSalesMan(testPerson2);
        manager.createSalesMan(testPerson3);
        //SalesMan s= manager.readSalesMan(12);
        //System.out.println(s.getFirstname());
        /*LinkedList<SalesMan> list = (LinkedList<SalesMan>) manager.querySalesMan("steve","firstname");
        for(SalesMan e : list){
            System.out.println(e.getFirstname());
        }*/
    }
}
