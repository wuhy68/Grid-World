package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


@SuppressWarnings("serial")
public class CalculatorUpgrade extends JFrame {
    private JTextField textField; 
	  
    private void init() {
        textField = new JTextField();   
        textField.setEditable(false);
        textField.setHorizontalAlignment (JTextField.RIGHT);
        textField.setFont(new Font(null, Font.PLAIN, 40));
        textField.setMargin(new Insets(50,0,50,0));
        
   
        JPanel panel = new JPanel();
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbs = new GridBagConstraints();
        panel.setLayout(gbl);
        
        Container container = getContentPane();
        container.add(textField, BorderLayout.NORTH);
        container.add(panel, BorderLayout.CENTER);
        
        JButton btMC = createButton("MC");
        JButton btMR = createButton("MR");
        JButton btMS = createButton("MS");
        JButton btMsub = createButton("M-");
        JButton btMadd = createButton("M+");
        panel.add(btMC);
        panel.add(btMR);
        panel.add(btMS);
        panel.add(btMadd);
        panel.add(btMsub);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=0;gbs.gridy=0;
        gbl.setConstraints(btMC, gbs);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=1;gbs.gridy=0;
        gbl.setConstraints(btMR, gbs);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=2;gbs.gridy=0;
        gbl.setConstraints(btMS, gbs);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=3;gbs.gridy=0;
        gbl.setConstraints(btMadd, gbs);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=4;gbs.gridy=0;
        gbl.setConstraints(btMsub, gbs);
        
        JButton btReturn = createButton("<-");
        JButton btCE = createButton("CE");
        JButton btC = createButton("C");
        JButton btAdd_Sub = createButton("+-");
        JButton btSqrt = createButton("  ");
        panel.add(btReturn);
        panel.add(btCE);
        panel.add(btC);
        panel.add(btAdd_Sub);
        panel.add(btSqrt);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=0;gbs.gridy=1;
        gbl.setConstraints(btReturn, gbs);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=1;gbs.gridy=1;
        gbl.setConstraints(btCE, gbs);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=2;gbs.gridy=1;
        gbl.setConstraints(btC, gbs);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=3;gbs.gridy=1;
        gbl.setConstraints(btAdd_Sub, gbs);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=4;gbs.gridy=1;
        gbl.setConstraints(btSqrt, gbs);
        
        JButton bt7 = createButton("7");
        JButton bt8 = createButton("8");
        JButton bt9 = createButton("9");
        JButton btDivide = createButton("/");
        JButton btCom = createButton("%");
        panel.add(bt7);
        panel.add(bt8);
        panel.add(bt9);
        panel.add(btDivide);
        panel.add(btCom);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=0;gbs.gridy=2;
        gbl.setConstraints(bt7, gbs);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=1;gbs.gridy=2;
        gbl.setConstraints(bt8, gbs);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=2;gbs.gridy=2;
        gbl.setConstraints(bt9, gbs);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=3;gbs.gridy=2;
        gbl.setConstraints(btDivide, gbs);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=4;gbs.gridy=2;
        gbl.setConstraints(btCom, gbs);
        
        JButton bt4 = createButton("4");
        JButton bt5 = createButton("5");
        JButton bt6 = createButton("6");
        JButton btMul = createButton("*");
        JButton btFrac = createButton("1/x");
        panel.add(bt4);
        panel.add(bt5);
        panel.add(bt6);
        panel.add(btMul);
        panel.add(btFrac);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=0;gbs.gridy=3;
        gbl.setConstraints(bt4, gbs);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=1;gbs.gridy=3;
        gbl.setConstraints(bt5, gbs);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=2;gbs.gridy=3;
        gbl.setConstraints(bt6, gbs);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=3;gbs.gridy=3;
        gbl.setConstraints(btMul, gbs);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=4;gbs.gridy=3;
        gbl.setConstraints(btFrac, gbs);
        
        JButton bt1 = createButton("1");
        JButton bt2 = createButton("2");
        JButton bt3 = createButton("3");
        JButton btSub = createButton("-");
        JButton btEqual = createButton("=");
        panel.add(bt1);
        panel.add(bt2);
        panel.add(bt3);
        panel.add(btSub);
        panel.add(btEqual);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=0;gbs.gridy=4;
        gbl.setConstraints(bt1, gbs);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=1;gbs.gridy=4;
        gbl.setConstraints(bt2, gbs);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=2;gbs.gridy=4;
        gbl.setConstraints(bt3, gbs);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=3;gbs.gridy=4;
        gbl.setConstraints(btSub, gbs);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=2;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=4;gbs.gridy=4;
        gbl.setConstraints(btEqual, gbs);
        
        JButton bt0 = createButton("0");
        JButton btPoint = createButton(".");
        JButton btAdd = createButton("+");
        panel.add(bt0);
        panel.add(btPoint);
        panel.add(btAdd);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=2;gbs.gridheight=1;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=0;gbs.gridy=5;
        gbl.setConstraints(bt0, gbs);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=2;gbs.gridy=5;
        gbl.setConstraints(btPoint, gbs);
        gbs.fill=GridBagConstraints.BOTH;gbs.gridwidth=1;gbs.gridheight=1;
        gbs.insets=new Insets(5, 5, 5, 5);gbs.weightx=1;gbs.weighty=1;
        gbs.gridx=3;gbs.gridy=5;
        gbl.setConstraints(btAdd, gbs);

    }
    
    public JButton createButton (String key) {

        JButton button = new JButton(key);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	JButton sourceBtn = (JButton) event.getSource();
                String bottonKey = sourceBtn.getText();
                try {
					calculatorAction(bottonKey);
				} catch (ScriptException e) {
					e.printStackTrace();
				}
            }
        });
        
        return button;
    }
    
    private boolean judge(String to_judge) {
    	if(to_judge.charAt(to_judge.length()-1) == '/' || to_judge.charAt(to_judge.length()-1) == '+' || 
    			to_judge.charAt(to_judge.length()-1) == '-' || to_judge.charAt(to_judge.length()-1) == '*' || 
    		    to_judge.charAt(to_judge.length()-1) == '.' || to_judge.charAt(to_judge.length()-1) == '(')
    		return false;
    	for(int count = 0 ; count < to_judge.length() - 1; ++count){
    		if(to_judge.charAt(count) == '(' && to_judge.charAt(count + 1) == ')') {
    			return false;
    		}
    		if((to_judge.charAt(count) == '/' || to_judge.charAt(count) == '+' || to_judge.charAt(count) == '-' || to_judge.charAt(count) == '*' || to_judge.charAt(count) == '.')
    			&& (to_judge.charAt(count + 1) == '/' || to_judge.charAt(count + 1) == '+' || to_judge.charAt(count + 1)  == '-' || to_judge.charAt(count + 1)  == '*' || to_judge.charAt(count + 1)  == '.')){
    			return false;	
    		}
    		if(to_judge.charAt(count) == '(' && (to_judge.charAt(count + 1) == '*' || to_judge.charAt(count + 1) == '/')){
    			return false;	
    		}
    	}
    	int match = 0;
    	for( int count = 0 ; count < to_judge.length() ; ++count){
    		if(to_judge.charAt(count) == '(' ) ++match;
    		if(to_judge.charAt(count) == ')') --match;
    		if(match < 0){
    			return false;
    		}
    	}
    	if(match != 0) return false;
    	if(to_judge.charAt(0) == '/' || to_judge.charAt(0) == '*' || to_judge.charAt(0) == ')') return false;
    	return true;
    }
    int flag = 0;
    int wrong_flag = 0;
    private void calculatorAction(String key) throws ScriptException {
    	
        switch(key) {
            case ".":
            case "0":
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
            case "(":
            case ")":
            	if(flag == 1)  {
            		flag = 0 ;
            		textField.setText("");
            	}
                String text = textField.getText() + key;
                textField.setText(text);
                break;
            case "+":
            case "/":
            case "-":
            case "*":
            	flag = 0;
                String text1 = textField.getText() + key;
                textField.setText(text1);
                break;            	
            case "CE":
                textField.setText("");
                break;     
            case "��":
            	String new_text = "";
            	String origin = textField.getText();
            	for(int i = 0 ; i < textField.getText().length()-1 ; ++i) {
            		new_text += origin.charAt(i);
            	}
            	textField.setText(new_text);
            	break;
            case "=":
            	String fin = textField.getText();
            	if(judge(fin) == false) {
            		textField.setText("Wrong!");
            		flag = 1;
            		wrong_flag = 1;
            		break;
            	}
        		ScriptEngineManager manager = new ScriptEngineManager();
        		ScriptEngine engine = manager.getEngineByName("js");
        		Object result = engine.eval(fin);
        		String res = result.toString();
        		textField.setText(res);
        		flag = 1;
            	break;
            default:
            	break;
        }
    }
    
    public static void main(String[] args) {
        CalculatorUpgrade calculator = new CalculatorUpgrade();
        
        calculator.setTitle("Calculator");
        calculator.setSize(500, 600);
        calculator.setResizable(false);
        calculator.setLocationRelativeTo(null);
        calculator.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        calculator.init();
        calculator.setVisible(true);
    }
}


