package com.kaleb.calculatorapp;

public class CalculatorModel {
    private String currentInput = "0"; // displayed number
    private double accumulator = 0.0; // Left hand value for operations
    private char operator = '\0'; // current operator +, -, * /
    private boolean startNewNumber = true;

    //INput handler
    public void inputDigit(char d) {
        if (d == 'C') {
            clear();
            return;
        }

        // Toggle negative sign
        if (d == '-') {
            if (currentInput.startsWith("-")) {
                currentInput = currentInput.substring(1);
            } else {
                currentInput = "-" + currentInput;
            }
            return;
        }

        // Handle digits 0–9 // some weirdness with pressing 0 then another number but //fix later
        if (Character.isDigit(d)) {
            if (startNewNumber) {
                currentInput = String.valueOf(d);
                startNewNumber = false;
                return;
            }

            // Replace a single leading 0 or -0
            if (currentInput.equals("0")) {
                currentInput = String.valueOf(d);
            } else if (currentInput.equals("-0")) {
                currentInput = "-" + d;
            } else {
                currentInput += d;
            }
        }
    }

    //Operator handle
    public void setOperator(char op) {
        double currentValue = safeParse(currentInput);

        if (operator != '\0' && !startNewNumber) {
            compute(currentValue);
        } else {
            accumulator = currentValue;
        }

        operator = op;
        startNewNumber = true;
    }

    // core (take left hand and (rhs) Right hand side and perform operation via set operation in state)
    public void compute(double rhs) {
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
                if (rhs == 0) {
                    currentInput = "Error";
                    resetAfterError();
                    return;
                }
                accumulator /= rhs;
                break;
            default:
                // no operator yet, treat as assignment
                accumulator = rhs;
                break;
        }

        currentInput = stripTrailingZeros(accumulator);
        operator = '\0';
        startNewNumber = true;
    }

    // ===== Reset Logic =====
    public void clear() {
        accumulator = 0.0;
        currentInput = "0";
        operator = '\0';
        startNewNumber = true;
    }

    private void resetAfterError() {
        accumulator = 0.0;
        operator = '\0';
        startNewNumber = true;
    }

    // ===== Helpers =====
    private double safeParse(String text) {
        try {
            return Double.parseDouble(text);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    private String stripTrailingZeros(double value) { //odd fix but works to remove left hand zero after we press zero on True == startNewNumber
        String s = Double.toString(value);
        if (s.endsWith(".0"))
            s = s.substring(0, s.length() - 2);
        return s;
    }

    // ===== Getters =====
    public double getResult() {
        return safeParse(currentInput);
    }

    public String getDisplay() {
        return (currentInput == null || currentInput.isEmpty()) ? "0" : currentInput;
    }
}