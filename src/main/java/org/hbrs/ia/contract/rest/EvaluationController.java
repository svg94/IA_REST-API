package org.hbrs.ia.contract.rest;

import org.hbrs.ia.contract.ManagePersonal;
import org.hbrs.ia.contract.rest.helper.EvalJsonWrapper;
import org.hbrs.ia.model.EvaluationRecord;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/EvaluationRecords")
public class EvaluationController {
    private ManagePersonal m = RestApplication.manager;

    @GetMapping
    public String StartScreen(){
        return "Category: EvaluationRecords";
    }

    @GetMapping("/{id}")
    public EvaluationRecord getRecordOfID(@PathVariable() int id){
        return m.readEvaluationRecords(id);
    }


    @PostMapping("/{id}")
    public void createEvalForID(@PathVariable()int id, @RequestBody() EvalJsonWrapper ew) throws Exception {
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(ew.leadershipCompetence[0],ew.leadershipCompetence[1]));       //Design Mistake with the ArrayLists...
        ArrayList<Integer> o = new ArrayList<>(Arrays.asList(ew.openness[0],ew.openness[1]));
        ArrayList<Integer> s = new ArrayList<>(Arrays.asList(ew.social[0],ew.social[1]));
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(ew.attitudeToClient[0],ew.attitudeToClient[1]));
        ArrayList<Integer> c = new ArrayList<>(Arrays.asList(ew.communicationSkills[0],ew.communicationSkills[1]));
        ArrayList<Integer> i = new ArrayList<>(Arrays.asList(ew.integrityToCompany[0],ew.integrityToCompany[1]));

        EvaluationRecord e = new EvaluationRecord(l,o,s,a,c,i);
        m.addPerformanceRecord(e,id);
    }
}
