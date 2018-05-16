package com.cs.data;

public class LabelData {

	double[] data;
	Object label;

	public LabelData(double[] data, Object label) {
		this.data = data;
		this.label = label;
	}

	public double[] getData() {

		return this.data;
	}

	public Object getLabel() {
		return this.label;
	}

}
