package com.cs.ai.data;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.cs.util.CSVProcess;
import com.cs.util.IOUtil;

public class DataSet {

	private Labels labels;

	private ArrayList<Double[]> alData = new ArrayList<Double[]>();

	public DataSet(Labels labels) {

		this.labels = labels;
	}

	public void loadCSVFile(String fileName, boolean passFirstLine) throws FileNotFoundException, IOException {

		DataSetCSVProcess csvProc = new DataSetCSVProcess(this,passFirstLine);
		IOUtil.processCSVFile(fileName, csvProc);

	}

	public void addData(String[] lineDatas) {

		Double[] d = new Double[lineDatas.length];

		for (int i = 0; i < lineDatas.length; i++) {

			d[i] = labels.getNumsValue(i, lineDatas[i]);

		}

		alData.add(d);
	}

	public int getSize() {
		return alData.size();
	}

	public Double[] getData(int index) {
		return alData.get(index);
	}

	public void printToConsole() {

		for (int i = 0; i < labels.getSize(); i++) {

			System.out.print(labels.getName(i) + "\t");

		}

		System.out.println("");

		for (int i = 0; i < this.getSize(); i++) {

			Double[] d = this.getData(i);
			for (int k = 0; k < d.length; k++) {
				System.out.print(d[k] + "\t");
			}
			System.out.println("");

		}

	}
}

class DataSetCSVProcess implements CSVProcess {

	boolean passFirstLine;
	
	DataSet ds;

	public DataSetCSVProcess(DataSet ds,boolean passFirstLine) {
		this.ds=ds;
		this.passFirstLine = passFirstLine;
	}

	@Override
	public void processLine(String line) {

		if (this.passFirstLine) {
			this.passFirstLine = false;
			return;
		}
		
		String[] data=line.split(",");
		
		this.ds.addData(data);
		
		

	}

}
