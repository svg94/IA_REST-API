package org.hbrs.ia.test;

import org.hbrs.ia.model.EvaluationRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.bson.Document;

public class EvalRecordTest {

    @BeforeEach
    void setup(){

    }

    @Test
    void testEvalRecordToDocument() throws Exception{
        EvaluationRecord eval = new EvaluationRecord(new Integer[]{2,1},new Integer[]{3,1},new Integer[]{4,1},new Integer[]{5,1},new Integer[]{6,1},new Integer[]{7,1});
        Document d = eval.toDocument();

        Integer[] dLeadership = (Integer[]) d.get("leadershipcompetence");
        assertEquals(2,dLeadership[0]);
    }
    //TODO: Teste EvalRead and Add.
}
