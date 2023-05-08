package finalproject;

import java.util.Scanner;

/**
 *
 * @author Calvin Stepan, Noah Gunderson, Trey Mathieu
 */
public class FinalProject {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        Dao.connectToDatabase();
        MenuInterface.showMenu(scanner);
        scanner.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FinalProject project = new FinalProject();
        project.start();
    }
}
