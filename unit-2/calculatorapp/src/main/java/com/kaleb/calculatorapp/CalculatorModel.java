package com.kaleb.calculatorapp;

public class CalculatorModel 
{
    public String currentInput = "0"; // aka the display
    
    private double accumulator = 0.0;
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
            double currentValue = Double.parseDouble(currentInput);
            if (operator != '\0' && !startNewNumber) {
                compute(currentValue);
            } else {
                accumulator = currentValue;
            }
            operator = d;
            startNewNumber = true;

    }

    public void compute(double rhs){
        switch (operator) {
            case '+':
                accumulator += rhs;
                break;
            case '-':
                accumulator -= rhs;
                break;
            case '*':
                accumulator *= rhs;
                break;
            case '/':
                if (rhs == 0){
                    currentInput = "Error";
                    operator = '\0';
                    startNewNumber = true;
                    return;
                }
                accumulator /= rhs;
                break;
            default:
                accumulator = rhs;
                break;
        }
        currentInput = String.valueOf(accumulator);
        startNewNumber = true;
        operator = '\0';
    }

    public void clear(){
        accumulator = 0.0;
        currentInput = "0";
        operator = '\0';
        startNewNumber = true;

    }

    public double getResult(){
        return Double.parseDouble(currentInput); 
    }

    public static void main(String[] args) {
        CalculatorModel calculatorModel = new CalculatorModel();
        
    }
    


}