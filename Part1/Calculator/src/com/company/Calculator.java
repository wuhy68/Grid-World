package com.company;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;

public class Calculator extends JFrame{

    public Calculator() {

	JPanel calculator;
	JLabel result, operator, equal;
	JTextField num1, num2;
	JButton add, sub, mul, div, ok;

	int fontsize = 60;
	
	setBounds(200, 200, 900, 400);		
	setTitle("Easy Carculator");			

	num1 = new JTextField("12");
	num2 = new JTextField("2");
        num1.setFont(new Font("宋体", Font.BOLD, fontsize));
	num1.setHorizontalAlignment(JTextField.CENTER);
	num1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        num2.setFont(new Font("宋体", Font.BOLD, fontsize));
	num2.setHorizontalAlignment(JTextField.CENTER);
	num2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	
        result = new JLabel("", JLabel.CENTER);	
	result.setFont(new Font("宋体", Font.BOLD, fontsize));
	result.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	operator = new JLabel("", JLabel.CENTER);
        operator.setFont(new Font("宋体", Font.BOLD, fontsize));
	operator.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	equal = new JLabel("=", JLabel.CENTER);
	equal.setFont(new Font("宋体", Font.BOLD, fontsize));
	equal.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	add = new JButton("+");
	sub = new JButton("-");
	mul = new JButton("*");
	div = new JButton("/");
	ok = new JButton("OK");

	add.setFont(new Font("宋体", Font.BOLD, fontsize));
	sub.setFont(new Font("宋体", Font.BOLD, fontsize));
	mul.setFont(new Font("宋体", Font.BOLD, fontsize));		
	div.setFont(new Font("宋体", Font.BOLD, fontsize));
	ok.setFont(new Font("宋体", Font.BOLD, fontsize));

	add.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	sub.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	mul.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	div.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	ok.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	calculator = new JPanel();
	calculator.setLayout(new GridLayout(2,5));
	calculator.add(num1); 
	calculator.add(operator);
	calculator.add(num2);  
	calculator.add(equal);
	calculator.add(result);
	calculator.add(add);  
	calculator.add(sub);  
	calculator.add(mul);  
	calculator.add(div);
	calculator.add(ok);
	add(calculator);

	ActionListener operation = new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		operator.setText(((JButton)e.getSource()).getText());
	    }
	};
		
	add.addActionListener(operation);
	sub.addActionListener(operation);
	mul.addActionListener(operation);
	div.addActionListener(operation);

	ActionListener calculate = new ActionListener() {
	    public void actionPerformed(ActionEvent e){
		result.setText("");
		double x = Double.parseDouble(num1.getText());
		double y = Double.parseDouble(num2.getText());
                
		if (operator.getText().equals("+")) {
		    result.setText("" + (x + y));
		} else if (operator.getText().equals("-")) {
		    result.setText("" + (x - y));
		} else if (operator.getText().equals("*")) {
		    result.setText("" + (x * y));
		} else if (operator.getText().equals("/")){
		    if (y == 0) {
			result.setText("NaN");
		    } else {
		    	result.setText("" + (x / y));
		    }
	        }
	    }
	};	

	ok.addActionListener(calculate);

        setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
	new Calculator();
    }
} 
