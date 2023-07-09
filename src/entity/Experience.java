package entity;

import java.sql.Date;

public class Experience extends Candidate {
    private int expInYear;
    private String proSkill;

    public Experience(int candidateID, String fullName, Date birthDay, String phone,
                      String email, String candidateType, int expInYear, String proSkill) {
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
    public String toString() {
        return super.toString() +
                "Experience{" +
                "expInYear=" + expInYear +
                ", proSkill='" + proSkill + '\'' +
                '}';
    }

    @Override
    public void showMe() {
        System.out.println(this);
    }
}
