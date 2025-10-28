package com.kaleb.calculatorapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorView extends JPanel {
    private JTextField display;
    private JButton[] digitButtons;
    private JButton addButton, subButton, mulButton, divButton, clearButton, equalsButton;

    public CalculatorView() {
        setLayout(new BorderLayout());

        // Display field
        display = new JTextField("0");
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Number buttons
        digitButtons = new JButton[10];
        JPanel numberPanel = new JPanel(new GridLayout(4, 3));
        for (int i = 1; i <= 9; i++) {
            digitButtons[i] = new JButton(String.valueOf(i));
            numberPanel.add(digitButtons[i]);
        }
        digitButtons[0] = new JButton("0");
        numberPanel.add(digitButtons[0]);
        clearButton = new JButton("C");
        numberPanel.add(clearButton);
        add(numberPanel, BorderLayout.CENTER);

        // Operator buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equalsButton = new JButton("=");
        JPanel opPanel = new JPanel(new GridLayout(5, 1));
        opPanel.add(addButton);
        opPanel.add(subButton);
        opPanel.add(mulButton);
        opPanel.add(divButton);
        opPanel.add(equalsButton);
        add(opPanel, BorderLayout.EAST);
    }

    public void setDisplayText(String text) {
        display.setText(text);
    }

    public String getDisplayText() {
        return display.getText();
    }

    public void addButtonListener(ActionListener listener) {
        for (JButton b : digitButtons)
            b.addActionListener(listener);
        addButton.addActionListener(listener);
        subButton.addActionListener(listener);
        mulButton.addActionListener(listener);
        divButton.addActionListener(listener);
        equalsButton.addActionListener(listener);
        clearButton.addActionListener(listener);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new CalculatorView());
        frame.pack();
        frame.setVisible(true);
    }
}