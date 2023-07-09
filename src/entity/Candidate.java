package entity;

import java.sql.Date;

public class Candidate {
    private int candidateID;
    private String fullName;
    private Date birthDay;
    private String phone;
    private String email;
    private int candidateType;
    public static int candidateCount = 0;

    public Candidate(){
        candidateCount++;
    }

    public Candidate(int candidateID, String fullName, Date birthDay, String phone, String email, int candidateType) {
        super();
        this.candidateID = candidateID;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
        candidateCount++;
    }

    public int getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return String.valueOf(birthDay);
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(int candidateType) {
        this.candidateType = candidateType;
    }


    public String showMe() {
        return "Candidate{" +
                "candidateID=" + candidateID + '\n' +
                ", fullName='" + fullName + '\n' +
                ", birthDay=" + birthDay + '\n' +
                ", phone='" + phone + '\n' +
                ", email='" + email + '\n' +
                ", candidateType='" + candidateType + '\n' +
                ", candidateCount=" + candidateCount +
                '}';
    }
}
