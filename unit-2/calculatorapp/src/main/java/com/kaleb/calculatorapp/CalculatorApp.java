package com.kaleb.calculatorapp;
// package com.kaleb.calculatorapp.TestModel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;



public class CalculatorApp extends JFrame
{
    public CalculatorApp() {
        setTitle("Kalebs Calculator (Event-Based)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public static void main( String[] args )
    {
        System.out.println( "Running Test!" );
        TestModel.main(args);


    }
}
