/*
 * Emma Kordik
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberguessgame;

import java.util.Random;

/**
 *
 * @author emmakordik
 */
public class NumberGuessService {
    private int randomNum;
    private Random random = new Random();
    private int min;
    private int max;
    
    public NumberGuessService(int min, int max){
       this.min = min;
       this.max = max;
       setNumber();
       
    }
    
    public void setNumber(){
        randomNum = random.nextInt(max-min)+1+min;
    }
    
    public NumberGuessResults guessNumber(String guess)throws  NumberFormatException{
        int guessNum = Integer.parseInt(guess);
        
        if(guessNum < min || guessNum > max){
            throw new IllegalArgumentException();
        }
        
        if(guessNum == randomNum){
            return NumberGuessResults.RIGHT;
        }else if(guessNum < randomNum){
            return NumberGuessResults.LOW;
        }else{
            return NumberGuessResults.HIGH;
        }
        
    }
}
