package com.kaleb.calculatorapp;

public class CalculatorModel 
{
    private double accumulator = 0.0;
    private String currentInput = "0";
    private char operator = '\0';
    private boolean startNewNumber = true;



    
    public void inputDigit(char d){
        switch (d) {
            
            case '-':
                // if number is negative, make positive
                // one possible issue hereis a negative 0? 
                // keep in mind for other operations
                if (currentInput.charAt(0) == '-'){
                    currentInput = currentInput.substring(1); //get substring after '-'
                } else {
                    currentInput = "-" + currentInput;
                }
                break;

            case '0':
                if (currentInput.equals("0") || currentInput.equals("-0")){
                    break;
                }
                currentInput += "0";                   
                break;
            case 'C':
                clear();
                break;

            default: //is a digit
                if (startNewNumber){
                    startNewNumber = false;
                    currentInput = String.valueOf(d);
                } else {
                    currentInput += d;
                }
                break;

        }
    }

    public void setOperator(char d){
        
    }
    public void compute(double rhs){

    }
    public void clear(){

    }
    public double getResult(){
        return 0.0; 
    }

    public static void main(String[] args) {
        CalculatorModel calculatorModel = new CalculatorModel();
        
    }
    


}