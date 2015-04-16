/*
 * Emma Kordik
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validatorutility.strategy;

/**
 *
 * @author emmakordik
 */
public interface Validatable {
    
    public abstract String getErrorMsg();
    
    public abstract void setErrorMsg(String errorMsg);
    
    public abstract void setValidator(Validatorable validator);
    
    public abstract Validatorable getValidator();
    
    //public abstract boolean isValid();
}
