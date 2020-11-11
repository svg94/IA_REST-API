package org.hbrs.ia.test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.hbrs.ia.contract.ManagePersonal;
import org.hbrs.ia.contract.Manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.hbrs.ia.model.SalesMan;
import static org.junit.jupiter.api.Assertions.*;

class HighPerformanceTest {

    private MongoClient client;
    private MongoDatabase supermongo;
    private MongoCollection<Document> salesmen;
    private ManagePersonal manager;

    @BeforeEach
    void setUp() {
        // Setting up the connection to a local MongoDB with standard port 27017
        // must be started within a terminal with command 'mongod'
        client = new MongoClient("localhost", 27017);

        // Get database 'highperformance' (creates one if not available)
        supermongo = client.getDatabase("highperformance");

        // // Get Collection 'salesmen' (creates one if not available)
        salesmen = supermongo.getCollection("salesmen");
        manager = new Manager();

    }

    @Test
    void insertSalesMan() {
        // CREATE (Storing) the salesman object
        Document document = new Document();
        document.append("firstname" , "Sascha");
        document.append("lastname" , "Alda");
        document.append("id" , 90133);

        // ... now storing the object
        salesmen.insertOne(document);

        // READ (Finding) the stored Documnent
        Document newDocument = this.salesmen.find().first();
        System.out.println("Printing the object (JSON): " + newDocument );

        // Assertion
        Integer id = (Integer) newDocument.get("id");
        assertEquals( 90133 , id );

        // Deletion
        salesmen.drop();
    }

    @Test
    void insertSalesManMoreObjectOriented() {
        // CREATE (Storing) the salesman business object
        // Using setter instead
        SalesMan salesMan = new SalesMan( "Leslie" , "Malton" , 90444 );

        // ... now storing the object
        salesmen.insertOne(salesMan.toDocument());

        // READ (Finding) the stored Documnent
        // Mapping Document to business object would be fine...
        Document newDocument = this.salesmen.find().first();
        System.out.println("Printing the object (JSON): " + newDocument );

        // Assertion
        Integer id = (Integer) newDocument.get("id");
        assertEquals( 90444 , id );

        // Deletion
        salesmen.drop();
    }

    @Test
    void testeManagerReadCreateSalesMan(){
        SalesMan dummy = new SalesMan("Test","Dummy",12345);
        manager.createSalesMan(dummy);

        SalesMan pulled = manager.readSalesMan(12345);

        //Assertion
        Integer id = pulled.getId();
        assertEquals(12345, id);

        manager.dropSalesMen();


    }



}
