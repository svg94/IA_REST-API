package org.hbrs.ia.test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.hbrs.ia.contract.ManagePersonal;
import org.hbrs.ia.contract.Manager;
import org.hbrs.ia.model.EvaluationRecord;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Arrays;

public class EvalRecordTest {

    private MongoClient client;
    private MongoDatabase supermongo;
    private ManagePersonal manager;
    private MongoCollection<Document> evalrecord;
    @BeforeEach
    void setup(){
        manager = new Manager();
    }

    @Test
    void testEvalRecordToDocument() throws Exception{
        EvaluationRecord testRecord = new EvaluationRecord(new ArrayList<>(Arrays.asList(2,1)),new ArrayList<>(Arrays.asList(2,1)),new ArrayList<>(Arrays.asList(2,1)),new ArrayList<>(Arrays.asList(2,1)),new ArrayList<>(Arrays.asList(2,1)),new ArrayList<>(Arrays.asList(2,1)));
        Document d = testRecord.toDocument();

        ArrayList<Integer> dLeadership = (ArrayList<Integer>) d.get("leadershipcompetence");
        assertEquals(2,dLeadership.get(0));
    }
    //TODO: Teste EvalRead and Add.
    @Test
    void testEvalReadAndAdd() throws Exception {        //I know the Parameter filling is not pretty but for testing purposes it's fine.
        EvaluationRecord testRecord = new EvaluationRecord(new ArrayList<>(Arrays.asList(2,1)),new ArrayList<>(Arrays.asList(2,1)),new ArrayList<>(Arrays.asList(2,1)),new ArrayList<>(Arrays.asList(2,1)),new ArrayList<>(Arrays.asList(2,1)),new ArrayList<>(Arrays.asList(2,1)));
        manager.addPerformanceRecord(testRecord,12);

        EvaluationRecord toTest = manager.readEvaluationRecords(12);
        Integer actual = toTest.getLeadershipCompetence().get(0);
        assertEquals(2,actual);
    }
    @AfterEach
    void cleanup(){
        manager.dropEvalRecord();
    }
}
