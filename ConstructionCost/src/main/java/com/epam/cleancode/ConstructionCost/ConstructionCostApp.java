package com.epam.cleancode.ConstructionCost;

import java.applet.Applet;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.logging.Logger;

public class ConstructionCostApp extends Applet implements ItemListener {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger("Hello");
	TextField areaField,result;
	CheckboxGroup materials_type;
	Checkbox standard_material,abovestandard_material,highstandard_material,highand_fullyautomated;
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
	
		areaField = new TextField(20);
		result = new TextField(20);
		result.setEditable(false);
		
		materials_type = new CheckboxGroup();
		
	    standard_material = new Checkbox("standard",materials_type,false);
	    abovestandard_material = new Checkbox("Above standard",materials_type,false);
	    highstandard_material = new Checkbox("High standard",materials_type,false);
	    highand_fullyautomated = new Checkbox("High and Fully automated",materials_type,false);
	    
	    add(new Label("Enter area of house in sq.feet"));
	    add(areaField);
	    add(new Label("Choose type of material"));
	    add(standard_material);
	    add(abovestandard_material);
	    add(highstandard_material);
	    add(highand_fullyautomated);
	    add(new Label("Total Construction cost in INR"));
	    add(result);
	    
	    standard_material.addItemListener(this);
	    abovestandard_material.addItemListener(this);
	    highstandard_material.addItemListener(this);
	    highand_fullyautomated.addItemListener(this);
	    
	    setSize(200,300);
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		String selected = materials_type.getSelectedCheckbox().getLabel();
		int area = Integer.parseInt(areaField.getText());
		if(selected == "standard")
		{
			log.info(String.valueOf(area*1200));
			result.setText(String.valueOf(area*1200));
		}
		else if(selected == "Above standard")
		{
			log.info(String.valueOf(area*1500));
			result.setText(String.valueOf(area*1500));
		}
		else if(selected == "High standard")
		{
			log.info(String.valueOf(area*1800));
			result.setText(String.valueOf(area*1800));
		}
		else if(selected == "High and Fully automated")
		{
			log.info(String.valueOf(area*2500));
			result.setText(String.valueOf(area*2500));
		}
		
	}
	

}
