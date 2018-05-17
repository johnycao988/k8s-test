package com.cs.ai.data;

import java.util.ArrayList;
import java.util.HashMap;

public class Labels {

	public final static int TYPE_STR = 1;
	public final static int TYPE_NUMS = 2;
	public final static int TYPE_BOOL = 3;

	ArrayList<Label> alLabels = new ArrayList<Label>();
 

	public Labels() {

	}
	
	public int getSize(){
		return alLabels.size();
	}

	public void addLabel(String name, int type) {

		alLabels.add(new Label(name, type));
	}

	public String getName(int labelIndex) {
		return alLabels.get(labelIndex).getName();
	}

	public int getType(int labelIndex) {
		return alLabels.get(labelIndex).getType();
	}


	
	public double getNumsValue(int labelIndex, String labelValue) {
		
		Label lb=this.alLabels.get(labelIndex);
		int type = lb.getType();

		switch (type) {

		case Labels.TYPE_BOOL:
			if (Boolean.valueOf(labelValue))
				return 1.0;
			else
				return 0;
		case Labels.TYPE_NUMS:
			return Double.valueOf(labelValue);
		default:
			return lb.getNumByLabelValue(labelValue);
		}

	}

}

class LabelConvert {

	HashMap<String, Double> hmNumValue = new HashMap<String, Double>();

	HashMap<Double, String> hmStrValue = new HashMap<Double, String>();

	double maxValue = 0.0;

	public LabelConvert() {

	}

	public double getNumByLabelValue(String labelValue) {

		String s = labelValue.toUpperCase();

		Double d = hmNumValue.get(s);

		if (d == null) {

			maxValue++;
			d = maxValue;
			Double dd = Double.valueOf(d);
			hmNumValue.put(s, dd);
			hmStrValue.put(dd, labelValue);

		}

		return d;

	}

	public String getLabelValueByNum(double labelValue) {

		return hmStrValue.get(new Double(labelValue));

	}

}

class Label {

	String name;
	int type;
	
	LabelConvert lc=new LabelConvert();

	public Label(String name, int type) {

		this.name = name;
		this.type = type;

	}

	public String getName() {

		return this.name;
	}

	public int getType() {
		return this.type;
	}
	
	
	public double getNumByLabelValue(String labelValue) {
 
            return lc.getNumByLabelValue(labelValue);
	}

	public String getLabelValueByNum(double labelValue) {

		 return lc.getLabelValueByNum(labelValue);

	}
	

}
