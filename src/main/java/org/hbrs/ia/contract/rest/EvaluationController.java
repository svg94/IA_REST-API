package org.hbrs.ia.contract.rest;

import org.hbrs.ia.model.EvaluationRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/EvaluationRecords")
public class EvaluationController {
    @GetMapping
    public EvaluationRecord getRecordOfID(){
        return null;
    }
}
