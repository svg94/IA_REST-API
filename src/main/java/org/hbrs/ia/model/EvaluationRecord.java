package org.hbrs.ia.model;

import org.bson.Document;

import java.util.ArrayList;

public class EvaluationRecord {
    //private Integer id;
    private ArrayList<Integer> leadershipCompetence;     //All attributes are Arrays with 2 elements (target, value)
    private ArrayList<Integer> openness;
    private ArrayList<Integer> social;
    private ArrayList<Integer> attitudeToClient;
    private ArrayList<Integer> communicationSkills;
    private ArrayList<Integer> integrityToCompany;

    public EvaluationRecord(ArrayList<Integer> leader, ArrayList<Integer> open, ArrayList<Integer> social, ArrayList<Integer> client, ArrayList<Integer> comm, ArrayList<Integer> integr) throws Exception {
        if(!checkForRightSize(leader, open, social, client, comm, integr)) throw new Exception("Wrong Input. Sizes of at least one input not correct.");
        this.leadershipCompetence = leader;
        this.openness = open;
        this.social = social;
        this.attitudeToClient = client;
        this.communicationSkills = comm;
        this.integrityToCompany = integr;
    }

    /*Building method for checking if array input has
     *the right size. Doing so I reduce complexity in
     *Constructor.(Better for maintenance)*/
    private boolean checkForRightSize(ArrayList<Integer> leader, ArrayList<Integer> open, ArrayList<Integer> social, ArrayList<Integer> client, ArrayList<Integer> comm, ArrayList<Integer> integr){
        return (leader.size() == 2) && (open.size() == 2) && (social.size() == 2) && (client.size() == 2) && (comm.size() == 2) && (integr.size() == 2);
    }

    public Document toDocument(){
        Document document = new Document();
        document.append("leadershipcompetence" , this.leadershipCompetence );
        document.append("openness" , this.openness );
        document.append("social" , this.social );
        document.append("attitudetowardsclients" , this.attitudeToClient );
        document.append("communicationskills" , this.communicationSkills );
        document.append("integritytocompany" , this.integrityToCompany );
        return document;
    }

    /*Getter and Setter*/

    public ArrayList<Integer> getLeadershipCompetence() {
        return leadershipCompetence;
    }

    public void setLeadershipCompetence(ArrayList<Integer> leadershipCompetence) {
        this.leadershipCompetence = leadershipCompetence;
    }

    public ArrayList<Integer> getOpenness() {
        return openness;
    }

    public void setOpenness(ArrayList<Integer> openness) {
        this.openness = openness;
    }

    public ArrayList<Integer> getSocial() {
        return social;
    }

    public void setSocial(ArrayList<Integer> social) {
        this.social = social;
    }

    public ArrayList<Integer> getAttitudeToClient() {
        return attitudeToClient;
    }

    public void setAttitudeToClient(ArrayList<Integer> attitudeToClient) {
        this.attitudeToClient = attitudeToClient;
    }

    public ArrayList<Integer> getCommunicationSkills() {
        return communicationSkills;
    }

    public void setCommunicationSkills(ArrayList<Integer> communicationSkills) {
        this.communicationSkills = communicationSkills;
    }

    public ArrayList<Integer> getIntegrityToCompany() {
        return integrityToCompany;
    }

    public void setIntegrityToCompany(ArrayList<Integer> integrityToCompany) {
        this.integrityToCompany = integrityToCompany;
    }
}
