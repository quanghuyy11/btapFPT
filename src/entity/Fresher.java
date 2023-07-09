package entity;

import java.sql.Date;

public class Fresher extends Candidate {
    private Date graduationDate;
    private String graduationRank;
    private String education;

    public Fresher(int candidateID, String fullName, Date birthDay, String phone, String email,
                   String candidateType, Date graduationDate, String graduationRank, String education) {
        super(candidateID, fullName, birthDay, phone, email, candidateType);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    @Override
    public String toString() {
        return super.toString() + '\n' +
                "Fresher{" +
                "graduationDate=" + graduationDate + '\n' +
                ", graduationRank='" + graduationRank + '\n' +
                ", education='" + education + '\n' +
                '}';
    }

    @Override
    public void showMe() {
        System.out.println(this);
    }
}
