package util;

public class SQLCommand {
    public static String CANDIDATE_QUERY_ADD = "INSERT INTO candidate (candidateID, fullName, birthDay, phone, email, candidateType) VALUES (?,?,?,?,?,?)";
    public static String EXPERIENCE_QUERY_ADD = "INSERT INTO experience (candidateID, expInYear, proSkill) VALUES (?,?,?)";
    public static String FRESHER_QUERY_ADD = "INSERT INTO fresher (candidateID, graduationDate, graduationRank, education) VALUES (?,?,?,?)";
    public static String INTERN_QUERY_ADD = "INSERT INTO intern (candidateID, majors, semester, universityName) VALUES (?,?,?,?)";
    public static String COUNT_CANDIDATE = "SELECT COUNT(*) FROM candidate";
    public static String CANDIDATE_FIND_ALL = "SELECT * FROM candidate";
    public static String CERTIFICATE_QUERY_ADD = "INSERT INTO certificate (certificateID, candidateID, certificateName, certificateRank, certificateDate) VALUES (?, ?, ?, ?, ?)";
}
