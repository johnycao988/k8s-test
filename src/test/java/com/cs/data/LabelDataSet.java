package com.cs.data;

import java.util.ArrayList;

public class LabelDataSet {

	ArrayList<LabelData> dataAl = new ArrayList<LabelData>();

	public LabelDataSet() {

	}

	public void addLabelData(double[] d, Object label) {

		LabelData ld = new LabelData(d, label);

		addLabelData(ld);

	}

	public void addLabelData(LabelData ld) {

		dataAl.add(ld);

	}

	public int getSize() {
		return dataAl.size();
	}

	public LabelData getLabelData(int index) {

		return dataAl.get(index);
	}

	public LabelData[] getAllLabelData() {

		return dataAl.toArray(new LabelData[0]);
	}

}
