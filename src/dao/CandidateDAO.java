package dao;

import entity.Candidate;

import java.sql.SQLException;


public interface CandidateDAO {
    void addDetailInfo(Candidate candidate) throws SQLException;
    void add(Candidate candidate);

}
