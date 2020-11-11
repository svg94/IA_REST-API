package org.hbrs.ia.model;

import org.bson.Document;

public class EvaluationRecord {
    //private Integer id;
    private Integer[] leadershipCompetence;     //All attributes are Arrays with 2 elements (target, value)
    private Integer[] openness;
    private Integer[] social;
    private Integer[] attitudeToClient;
    private Integer[] communicationSkills;
    private Integer[] integrityToCompany;

    public EvaluationRecord(Integer[] leader, Integer[] open, Integer[] social, Integer[] client, Integer[] comm, Integer[] integr) throws Exception {
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
    private boolean checkForRightSize(Integer[] leader, Integer[] open, Integer[] social, Integer[] client, Integer[] comm, Integer[] integr){
        return (leader.length == 2) && (open.length == 2) && (social.length == 2) && (client.length == 2) && (comm.length == 2) && (integr.length == 2);
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

    public Integer[] getLeadershipCompetence() {
        return leadershipCompetence;
    }

    public void setLeadershipCompetence(Integer[] leadershipCompetence) {
        this.leadershipCompetence = leadershipCompetence;
    }

    public Integer[] getOpenness() {
        return openness;
    }

    public void setOpenness(Integer[] openness) {
        this.openness = openness;
    }

    public Integer[] getSocial() {
        return social;
    }

    public void setSocial(Integer[] social) {
        this.social = social;
    }

    public Integer[] getAttitudeToClient() {
        return attitudeToClient;
    }

    public void setAttitudeToClient(Integer[] attitudeToClient) {
        this.attitudeToClient = attitudeToClient;
    }

    public Integer[] getCommunicationSkills() {
        return communicationSkills;
    }

    public void setCommunicationSkills(Integer[] communicationSkills) {
        this.communicationSkills = communicationSkills;
    }

    public Integer[] getIntegrityToCompany() {
        return integrityToCompany;
    }

    public void setIntegrityToCompany(Integer[] integrityToCompany) {
        this.integrityToCompany = integrityToCompany;
    }
}
