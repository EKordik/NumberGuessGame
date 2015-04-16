/*
 * Emma Kordik
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validatorutility.strategy;

import javax.swing.JTextField;

/**
 *
 * @author emmakordik
 */
public class JTextFieldValidateable extends JTextField implements Validatable {
    private String errorMsg;
    private Validatorable validator;
    
    public JTextFieldValidateable(int col){
        super(col);
    }
    
    public JTextFieldValidateable(Validatorable validator){
        this.setValidator(validator);
    }
    @Override
    public String getErrorMsg() {
        return errorMsg;
    }

    @Override
    public void setErrorMsg(String errorMsg) throws IllegalArgumentException{
        if(errorMsg == null || errorMsg.length() == 0){
            throw new IllegalArgumentException();
        }
        this.errorMsg = errorMsg;
    }

    @Override
    public void setValidator(Validatorable validator)throws IllegalArgumentException {
        if(validator == null){
            throw new IllegalArgumentException();
        }
        this.validator = validator;
    }
    
    public Validatorable getValidator(){
        return validator;
    }
    
    public boolean isFieldValid(){
        String text = getText();
        boolean results = validator.isValid(text);
         return results;
     }
}
