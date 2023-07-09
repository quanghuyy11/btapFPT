package entity;

import java.sql.Date;

public class Experience extends Candidate {
    private int expInYear;
    private String proSkill;

    public Experience(int candidateID, String fullName, Date birthDay, String phone,
                      String email, int candidateType, int expInYear, String proSkill) {
        super(candidateID, fullName, birthDay, phone, email, candidateType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String showMe() {

        return super.showMe() + '\n' +
                "Experience:" + '\n' +
                "expInYear=" + expInYear + '\n' +
                "proSkill='" + proSkill;
    }
}
