package entity;

import java.io.Serializable;
import java.sql.Date;

public abstract class Candidate implements Serializable {
    private static final long serialVersionUID = 1L;
    private int candidateID;
    private String fullName;
    private Date birthDay;
    private String phone;
    private String email;
    private String candidateType;
    private int candidateCount;


    public Candidate(int candidateID, String fullName, Date birthDay, String phone, String email, String candidateType) {
        super();
        this.candidateID = candidateID;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
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
        return birthDay;
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

    public String getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(String candidateType) {
        this.candidateType = candidateType;
    }

    public int getCandidateCount() {
        return this.candidateCount++;
    }

    @Override
    public String toString() {
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

    public abstract void showMe();
}
