package org.hbrs.ia.contract.ui;

import org.hbrs.ia.model.EvaluationRecord;
import org.hbrs.ia.model.SalesMan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class ConsoleUI {
    private Scanner input;
    public ConsoleUI(){
        input = new Scanner(System.in);
    }

    public void startScreen(){
        print("-----------------------------------------------------");
        print("Welcome to Mongo-DB Client. What do you want to do?");
        print("Enter the key/number of the task you want to do.");
        print("[1] Look up a Salesman");
        print("[2] Query many Salesmen");
        print("[3] Create a Salesman");
        print("[4] Add a Performance Record to a Salesman");
        print("[5] Read a Performance Record");
        print("[Drop salesmen] Drop the Salesmen Collection");
        print("[Drop evalrecs] Drop the Evaluation-Records Collection");
        print("[Exit]");
        print("-----------------------------------------------------");
    }

    public String input(){
        return input.nextLine();
    }
    public SalesMan printCreateSalesMan(){
        print("So you wanna store a new Salesman in the database.");
        print("Please give me an ID his/her First- and Lastname.");
        print("Like so: ID,firstname,lastname");
        String input = input();
        String[] attr = input.split(",");
        return new SalesMan(attr[0],attr[1],Integer.valueOf(attr[2]));
    }
    public void printSalesMan(SalesMan s){
        print("........Salesman........");
        print("ID: "+s.getId());
        print("Vorname: "+s.getFirstname());
        print("Nachname: "+s.getLastname());
        print("........................");
    }
    public String printQueryStart(){
        print("Ok, please give me the key (category) and the value of it.");
        print("Like so: key,value");
        return input();
    }
    public EvaluationRecord printAddEvalRecord(){
        print("So you want to Add an Evaluation Record.");
        print("Please give me the Data in that form:");
        print("leadership;openness;social;attitudeToClient;CommunicationSkils;Integrity");
        print("Each category has exactly to values in that form:\nexpected,actual");
        print("So the input looks like this:");
        String input = input();
        String[] categories = input.split(";");
        Integer[][] allValues = new Integer[6][2];                          //[Category][expected,actual]
        for(int i = 0; i < categories.length; i++){                         //Put all Values from all Categories in a 2D-Array
            String[] values = categories[i].split(",");
            allValues[i][0] =Integer.valueOf(values[0]);
            allValues[i][1] =Integer.valueOf(values[1]);
        }
        ArrayList<Integer>[] attris = new ArrayList[6];
        for(int i = 0; i< attris.length; i++){
            attris[i] = new ArrayList<Integer>(Arrays.asList(allValues[i][0],allValues[i][1]));
        }
        try {
            return new EvaluationRecord(attris[0],attris[1],attris[2],attris[3],attris[4],attris[5]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void printReadEvalRecord(EvaluationRecord er, Integer id){
        print("...........................");
        print("SID: "+id);
        print("expected | actual");
        print("Leadership Competence: "+er.getLeadershipCompetence().get(0)+" | "+er.getLeadershipCompetence().get(1));
        print("Openness to Employee: "+er.getOpenness().get(0)+" | "+er.getOpenness().get(1));
        print("Social Behaviour to Employee: "+er.getSocial().get(0)+" | "+er.getSocial().get(1));
        print("Attitude towards Client: "+er.getAttitudeToClient().get(0)+" | "+er.getAttitudeToClient().get(1));
        print("Communication Skills: "+er.getCommunicationSkills().get(0)+" | "+er.getCommunicationSkills().get(1));
        print("Integrity to Company: "+er.getIntegrityToCompany().get(0)+" | "+er.getIntegrityToCompany().get(1));
        print("...........................");
    }
    public void print(String msg){
        System.out.println(msg);
    }
    public void pressToContinue(){
        print("Press any button to continue.");
        input();
    }
}
