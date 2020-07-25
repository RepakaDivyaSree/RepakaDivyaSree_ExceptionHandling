package com.epam.cleancode.SimpleAndCompoundInterest;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;


public class SimpleAndCompoundInterestApp extends Applet implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger("Hello");

	TextField principletextField,ratetextField,timetextField,resulttextField;
	Button simpleinterest_button,compoundinterest_button;
	
	@Override
	public void init() {
		super.init();

		principletextField = new TextField(20);
		ratetextField = new TextField(20);
		timetextField = new TextField(20);
		resulttextField = new TextField(20);
		resulttextField.setEditable(false);
		
		add(new Label("Enter Principle amount"));
		add(principletextField);
		add(new Label("Enter rate of interest per annum"));
		add(ratetextField);
		add(new Label("Enter Time period in years"));
		add(timetextField);
		add(new Label("Result"));
		add(resulttextField);
		
		simpleinterest_button = new Button("Simple Interest");
		compoundinterest_button = new Button("Compound Interest");
		
		simpleinterest_button.addActionListener(this);
		compoundinterest_button.addActionListener(this);
		
		add(simpleinterest_button);
		add(compoundinterest_button);
		
		setSize(200,400);
	}

	public void actionPerformed(ActionEvent e) {
		int principle = Integer.parseInt(principletextField.getText());
		double rate = Double.parseDouble(ratetextField.getText());
		int time_period = Integer.parseInt(timetextField.getText());
		double result = 0;
		
		if(e.getSource() == simpleinterest_button)
		{
			result  = (principle*time_period*rate) / 100;
		}
		else if(e.getSource() == compoundinterest_button)
		{
			result = principle * (Math.pow((1+rate/100), time_period)-1);
		}
		
		log.info(String.valueOf(result));
		resulttextField.setText(String.valueOf(result));
	}

}
