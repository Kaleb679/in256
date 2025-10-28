package com.kaleb.calculatorapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorView extends JPanel
{
    private JTextField display;
    private JButton[] digitButtons;
    private JButton addButton;
    private JButton subButton;
    private JButton mulButton;
    private JButton divButton;
    private JButton clearButton;
    private JButton equalsButton;

    public CalculatorView() {
        initComponents();
        layoutComponents();
        attachListeners();
    }

    private void initComponents() {
        return;
    }

    private void layoutComponents() {

    }

    private void attachListeners() {
        
    }

    public void setDisplayText(String text) {

    }

    public String getDisplayText(){

        return null;
    }

    public void addButtonListener(ActionListener listener) {
    }
}
