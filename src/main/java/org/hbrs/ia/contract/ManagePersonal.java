package org.hbrs.ia.contract;

import org.hbrs.ia.model.EvaluationRecord;
import org.hbrs.ia.model.SalesMan;

import java.util.List;

public interface ManagePersonal {
    //removed modifier public for releasing warnings.
    void createSalesMan( SalesMan record );

    void addPerformanceRecord(EvaluationRecord record , int sid );

    SalesMan readSalesMan( int sid );

    List<SalesMan> querySalesMan(String attribute , String key );

    EvaluationRecord readEvaluationRecords( int sid );

    //added interface method for dropping database for testing purposes.
    void dropSalesMen();
    void dropEvalRecord();
}
