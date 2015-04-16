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
public class NumbericRangeValidator implements Validatorable{
    private int min;
    private int max;
    
    public NumbericRangeValidator(String min, String max) throws NumberFormatException{
        this.min = Integer.parseInt(min);
        this.max = Integer.parseInt(max);
    }

    @Override
    public boolean isValid(String text) {
        int number;
        try{
            number = Integer.parseInt(text);
        }catch(NumberFormatException nfe){
            return false;
        }
        
        if(number < min || number > max){
            return false;
        }
        
        return true;
        
    }
}
