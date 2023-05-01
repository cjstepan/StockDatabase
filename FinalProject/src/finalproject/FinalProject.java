/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package finalproject;

import java.sql.SQLException;

/**
 *
 * @author calvin
 */
public class FinalProject {
    
    public void start() {
        Dao.connectToDatabase();
        //Add Menu stuff here
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FinalProject project = new FinalProject();
        project.start();
    }
    
}
