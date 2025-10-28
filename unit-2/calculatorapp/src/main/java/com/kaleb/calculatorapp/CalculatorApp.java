package com.kaleb.calculatorapp;

import javax.swing.*;
import java.awt.event.*;

// package com.kaleb.calculatorapp.TestModel;

public class CalculatorApp {
    
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorApp() {
        model = new CalculatorModel();
        view = new CalculatorView();
        initController();
    }
    
    private void handleInput(String input){
        char c = input.charAt(0);
        if (Character.isDigit(c)) {
            model.inputDigit(c);
        }
        else if ("+-*/".indexOf(c) >= 0){
            model.setOperator(c);
        }
        else if (c == '='){
            model.compute(Double.parseDouble(model.currentInput));
        }
        else if (c == 'C') {
            model.clear();
        }
    }

    private void initController() {
        view.addButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = e.getActionCommand();
                handleInput(input);
                view.setDisplayText(model.currentInput);
            }
        });
    }

    public static void main(String[] args) {
        System.out.println("Running Test!");
        TestModel.main(args);

    }
}
