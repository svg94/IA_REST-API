package org.hbrs.ia.main;

import org.hbrs.ia.contract.ManagePersonal;
import org.hbrs.ia.contract.Manager;
import org.hbrs.ia.contract.ui.ConsoleUI;
import org.hbrs.ia.model.EvaluationRecord;
import org.hbrs.ia.model.SalesMan;

import java.util.*;

public class Main {         /*Just testing out DB-features.*/
    public static void main(String[] args) {
        ManagePersonal manager = new Manager();
        ConsoleUI cui= new ConsoleUI();
        while(true){
            cui.startScreen();
            String taskToDo = cui.input();
            Integer id;
            switch(taskToDo) {
                case "1":   //LOOK UP SALESMAN
                    cui.print("Ok, then please give me the ID of the Salesman.");
                    String sid = cui.input();
                    SalesMan pulled = manager.readSalesMan(Integer.valueOf(sid));
                    if(pulled ==null)
                        cui.print("Tut mir leid, es wurde kein Salesman unter dieser ID gefunden.");
                    cui.printSalesMan(pulled);
                    break;
                case "2":   //QUERY SALESMEN
                    String input = cui.printQueryStart();
                    String[] keyvalue = input.split(",");
                    LinkedList<SalesMan> query = (LinkedList<SalesMan>) manager.querySalesMan(keyvalue[1],keyvalue[0]);
                    for(SalesMan s:query){
                        cui.printSalesMan(s);
                    }
                    break;
                case "3":   //CREATE SALESMAN
                    SalesMan toCreate = cui.printCreateSalesMan();
                    manager.createSalesMan(toCreate);
                    break;
                case "4":   //ADD EVALUATION RECORD
                    cui.print("Please give me the Salesman ID for the Performance Record.");
                    id = Integer.valueOf(cui.input());
                    EvaluationRecord toAdd = cui.printAddEvalRecord();
                    manager.addPerformanceRecord(toAdd,id);
                    break;
                case "5":   //READ EVALUATION RECORD
                    cui.print("Please give me the ID of the Salesman whose \nperformance records you want to read.");
                    id =Integer.valueOf(cui.input());
                    EvaluationRecord eval = manager.readEvaluationRecords(id);
                    cui.printReadEvalRecord(eval, id);
                    break;
                case "Drop salesmen":
                    manager.dropSalesMen();
                    break;
                case "Drop evalrecs":
                    manager.dropEvalRecord();
                    break;
                case "Exit":
                    return;
                default:
                    cui.print("Bro komm schon. Falscher Input.");
            }
            cui.pressToContinue();
        }
    }
}