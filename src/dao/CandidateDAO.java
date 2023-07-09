package dao;

import entity.Candidate;

import java.sql.SQLException;
import java.util.List;


public interface CandidateDAO {
    void addDetailInfo(Candidate candidate) throws SQLException;
    boolean addCandidateUsePrepared();
    Candidate inputCandidate();
    List<Candidate> getAllCandidate();
    void getFullName();
}
