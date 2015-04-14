/*
 * Emma Kordik
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberguessgame;

import javax.swing.UIManager;

/**
 *
 * @author emmakordik
 */
public class NumberGuessStartUp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         try {
            // Set Look & Feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            //Exception being ignored.
        }
        
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NumberGuessGUI().setVisible(true);
                
            }
        });
    }
    
}
