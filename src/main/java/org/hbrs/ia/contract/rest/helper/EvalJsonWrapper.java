package org.hbrs.ia.contract.rest.helper;

public class EvalJsonWrapper {
    public int[] leadershipCompetence;
    public int[] openness;
    public int[] social;
    public int[] attitudeToClient;
    public int[] communicationSkills;
    public int[] integrityToCompany;
    public EvalJsonWrapper(int[] l, int[] o, int[] s, int[] a, int[] c, int[] i){
        leadershipCompetence = l;
        openness = o;
        social = s;
        attitudeToClient = a;
        communicationSkills =c;
        integrityToCompany =i;
    }
}
