package entity;

import java.sql.Date;

public class Intern extends Candidate {
    private String majors;
    private String semester;
    private String universityName;

    public Intern(int candidateID, String fullName, Date birthDay, String phone,
                  String email, int candidateType, String majors, String semester, String universityName) {
        super(candidateID, fullName, birthDay, phone, email, candidateType);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String showMe() {
        return super.toString() + '\n' +
                "Intern:" + '\n' +
                "majors='" + majors + '\n' +
                "semester='" + semester + '\n' +
                "universityName='" + universityName;

    }
}
