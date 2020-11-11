package org.hbrs.ia.contract;


import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.hbrs.ia.model.EvaluationRecord;
import org.hbrs.ia.model.SalesMan;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Manager implements ManagePersonal{
    private MongoClient client;
    private MongoDatabase supermongo;
    private MongoCollection<Document> salesmen;
    private MongoCollection<Document> evalrecords;
    public Manager(){
        this.client = new MongoClient("localhost", 27017);
        // Get database 'highperformance' (creates one if not available)
        this.supermongo = client.getDatabase("highperformance");
        // // Get Collection 'salesmen' (creates one if not available)
        this.salesmen = supermongo.getCollection("salesmen");
        this.evalrecords = supermongo.getCollection("evaluationrecords");
    }
    @Override
    public void createSalesMan(SalesMan record) {
        salesmen.insertOne(record.toDocument());
    }

    @Override
    public void addPerformanceRecord(EvaluationRecord record, int sid) {
        Document document = new Document();
        document = record.toDocument();
        document.append("sid",sid);
        evalrecords.insertOne(document);
    }

    @Override
    public SalesMan readSalesMan(int sid) {
        Document pull = new Document(); //Create the query
        pull.append("id", sid);

        Document pulledDoc = this.salesmen.find(pull).first();  //Find a document with that id.
        String fname=pulledDoc.get("firstname").toString();     //split document attributes and put into a SalesMan Object.
        String lname=pulledDoc.get("lastname").toString();
        Integer id=(Integer) pulledDoc.get("id");
        SalesMan pulledSalesDude = new SalesMan(fname,lname,id);
        return pulledSalesDude;
    }

    @Override
    public List<SalesMan> querySalesMan(String attribute, String key) {
        LinkedList<SalesMan> pulled = new LinkedList<>();
        Document searchQuery = new Document();
        searchQuery.append(key, attribute);

        MongoCursor<Document> cursor = this.salesmen.find(searchQuery).iterator();
        while (cursor.hasNext()) {
            Document d = cursor.next();
            String fname = d.get("firstname").toString();
            String lname = d.get("lastname").toString();
            Integer id = (Integer) d.get("id");
            SalesMan s = new SalesMan(fname,lname,id);
            pulled.add(s);
        }
        return pulled;
    }

    /*Shouldnt this method return a List of Eval Records because one salesman can have multiple records?*/
    @Override
    public EvaluationRecord readEvaluationRecords(int sid) {
        Document pull = new Document(); //Create the query
        pull.append("sid", sid);

        Document d = evalrecords.find(pull).first();
        ArrayList<Integer> d1 = (ArrayList<Integer>) d.get("leadershipcompetence");
        ArrayList<Integer> d2 = (ArrayList<Integer>) d.get("openness");
        ArrayList<Integer> d3 = (ArrayList<Integer>) d.get("social");
        ArrayList<Integer> d4 = (ArrayList<Integer>) d.get("attitudetowardsclients");
        ArrayList<Integer> d5 = (ArrayList<Integer>) d.get("communicationskills");
        ArrayList<Integer> d6 = (ArrayList<Integer>) d.get("integritytocompany");
        EvaluationRecord pulled = null;
        try {
            pulled = new EvaluationRecord(d1, d2, d3, d4, d5, d6);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pulled;
    }


    @Override
    public void dropSalesMen() {
        salesmen.drop();
    }

    @Override
    public void dropEvalRecord() {
        evalrecords.drop();
    }
}
