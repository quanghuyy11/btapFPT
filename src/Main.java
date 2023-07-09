import dao.CandidateDAO;
import dao.CandidateDAOImpl;
import dao.CertificateDAO;
import dao.CertificateDAOImpl;
import java.util.Scanner;

public class Main {
    private static final CandidateDAO candidateDAO = new CandidateDAOImpl();
    private static final CertificateDAO certificateDAO = new CertificateDAOImpl();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            getMenu();
            System.out.println("Enter your choice:");
            choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    boolean check = candidateDAO.addCandidateUsePrepared();
                    if (check) {
                        System.out.println("Luu thanh cong! Ban se quay ve menu chinh!");
                    } else System.out.println("Ban khong luu duoc!");
                }
                case "2" -> {
                    boolean check = certificateDAO.addCertificate();
                    if (check) {
                        System.out.println("Luu thanh cong! Ban se quay ve menu chinh!");
                    } else System.out.println("Ban khong luu duoc!");
                }
                case "3" -> candidateDAO.getFullName();
                case "4" -> {
                    candidateDAO.getAllCandidate();
                }
                case "5" -> {

                }
                case "6" -> System.exit(0);
                default -> System.out.println("Invalid input!");
            }
        } while (true);
    }

    public static void getMenu() {
        System.out.println("-----Menu-----");
        System.out.println("1. Add new candidate");
        System.out.println("2. Add certificate");
        System.out.println("3. Display full name of candidates");
        System.out.println("4. Display information of candidates");
        System.out.println("5. Display information of candidates, sort by candidate type");
        System.out.println("6. Exit");
    }
}
