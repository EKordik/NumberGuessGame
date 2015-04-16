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
public class RequiredValidator implements Validatorable {
    @Override
    public boolean isValid(String text) {
        if(text == null || text.length() == 0){
            return false;
        }else{
            return true;
        }
    }
    
}
