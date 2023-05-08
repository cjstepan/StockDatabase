package finalproject;

/**
 *
 * @author Calvin Stepan, Noah Gunderson, Trey Mathieu
 */
public class FinalProject {

    public void start() {
        Dao.connectToDatabase();
        MenuInterface.showMenu();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FinalProject project = new FinalProject();
        project.start();

    }
}
