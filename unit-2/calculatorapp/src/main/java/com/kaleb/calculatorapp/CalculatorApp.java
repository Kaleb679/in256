package com.kaleb.calculatorapp;

import javax.swing.*;
import java.awt.event.*;

public class CalculatorApp {
    
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorApp() {
        model = new CalculatorModel();
        view = new CalculatorView();
        initController();
    }

    // Handle what happens when any button is pressed
    private void handleInput(String input) {
        char c = input.charAt(0);

        if (Character.isDigit(c)) {
            model.inputDigit(c);
        } 
        else if ("+-*/".indexOf(c) >= 0) {
            model.setOperator(c);
        } 
        else if (c == '=') {
            model.compute(Double.parseDouble(model.getDisplay()));
        } 
        else if (c == 'C') {
            model.clear();
        }

        // Always update the display after handling input
        view.setDisplayText(model.getDisplay());
    }

    // Connects the buttons to the logic
    private void initController() {
        view.addButtonListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleInput(e.getActionCommand());
            }
        });
    }

    // Build and display the calculator window
    private void showUI() {
        JFrame frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(view);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorApp app = new CalculatorApp();
            app.showUI();
        });
    }
}