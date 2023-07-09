package entity;

import java.sql.Date;

public class Fresher extends Candidate {
    private Date graduationDate;
    private String graduationRank;
    private String education;

    public Fresher(int candidateID, String fullName, Date birthDay, String phone, String email,
                   int candidateType, Date graduationDate, String graduationRank, String education) {
        super(candidateID, fullName, birthDay, phone, email, candidateType);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String showMe() {
        return super.showMe() + '\n' +
                "Fresher:" + '\n' +
                "graduationDate=" + graduationDate + '\n' +
                "graduationRank='" + graduationRank + '\n' +
                "education='" + education;
    }
}
