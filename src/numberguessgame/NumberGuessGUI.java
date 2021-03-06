/*
 * Emma Kordik
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberguessgame;

//import edu.wctc.validator.strategy.*;
import validatorutility.strategy.*;
import javax.swing.JOptionPane;

/**
 *
 * @author emmakordik
 */
public class NumberGuessGUI extends javax.swing.JFrame {
    private NumberGuessService guesser;
    private String min;
    private String max;
    private static final String RANGE_ERR_MSG = "Range Values must be Numbers";
    /**
     * Creates new form NumberGuessGUI
     */
    public NumberGuessGUI() {
        initComponents();        
        min = JOptionPane.showInputDialog("Enter the low end of the range: ");
        lblMin.setText(min);
        max = JOptionPane.showInputDialog("Enter the high end of the range: ");
        lblMax.setText(max);
         
        try{
            ((JTextFieldValidateable)txtGuess).setValidator(new NumbericRangeValidator(min,max));
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(rootPane, RANGE_ERR_MSG);
        }
        try{
            guesser = new NumberGuessService(min,max);
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(rootPane, RANGE_ERR_MSG);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRange = new javax.swing.JLabel();
        txtGuess = new validatorutility.strategy.JTextFieldValidateable(20);
        btnQuit = new javax.swing.JButton();
        btnGuess = new javax.swing.JButton();
        lblResults = new javax.swing.JLabel();
        lblMin = new javax.swing.JLabel();
        lblAnd = new javax.swing.JLabel();
        lblMax = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRange.setText("I've picked a number between ");

        txtGuess.setText("Enter a Number");

        btnQuit.setText("Quit");
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });

        btnGuess.setText("Guess");
        btnGuess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuessActionPerformed(evt);
            }
        });

        lblMin.setText("min");

        lblAnd.setText("and");

        lblMax.setText("max");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(lblResults))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(txtGuess, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(btnQuit)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuess))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblRange)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAnd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMax)))
                .addGap(0, 82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRange)
                    .addComponent(lblMin)
                    .addComponent(lblAnd)
                    .addComponent(lblMax))
                .addGap(18, 18, 18)
                .addComponent(txtGuess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQuit)
                    .addComponent(btnGuess))
                .addGap(38, 38, 38)
                .addComponent(lblResults)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuessActionPerformed
        // TODO add your handling code here:
        String number = txtGuess.getText();
        String results = "";
        
        if(((JTextFieldValidateable)txtGuess).isFieldValid()){
            try{
            switch(guesser.guessNumber(number)){
                case RIGHT: results = "You guessed the number!";
                    guesser.setNumber();
                    break;
                case LOW: results = "Too Low. Guess Again.";
                    break;
                case HIGH: results = "Too High. Guess Again.";
            }
            }catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(rootPane, "Enter a numer.");
            }
            lblResults.setText(results);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Please Provide a Value in the Range");
        }
    }//GEN-LAST:event_btnGuessActionPerformed

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnQuitActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuess;
    private javax.swing.JButton btnQuit;
    private javax.swing.JLabel lblAnd;
    private javax.swing.JLabel lblMax;
    private javax.swing.JLabel lblMin;
    private javax.swing.JLabel lblRange;
    private javax.swing.JLabel lblResults;
    private javax.swing.JTextField txtGuess;
    // End of variables declaration//GEN-END:variables
}
