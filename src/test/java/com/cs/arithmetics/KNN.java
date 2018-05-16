package com.cs.arithmetics;

import java.util.ArrayList;

import com.cs.data.LabelData;
import com.cs.data.LabelDataSet;

public class KNN {

	public static void getLabel(double[] testData, LabelDataSet lds, int k) {

		ArrayList<LabelDataDistance> al = new ArrayList<LabelDataDistance>();

		LabelData[] lda = lds.getAllLabelData();

		for (LabelData ld : lda) {

			double distance = EuclideanDistance.distance(testData, ld.getData());

			sortLabelData(al, ld, k, distance); 
			 

		}

	}

	private static void sortLabelData(ArrayList<LabelDataDistance> al, LabelData ld, int k, double distance) {

		if (al.size() < k) {
			LabelDataDistance ldd = new LabelDataDistance(ld, distance);
			al.add(ldd);
			return;
		}

		int index = -1;

		double d = 0.0;

		for (int i = 0; i < al.size(); i++) {

			double dd = al.get(i).getDistance();

			System.out.print(dd+",");
			if (dd > distance && dd > d) {

				d = dd;
				index = i;

			}

		}

		
		if (index >= 0) {
			LabelDataDistance ldd = new LabelDataDistance(ld, distance);
			al.set(index, ldd);
			System.out.print(" update index:"+ index);

		}

		System.out.println("");

	}

}

class LabelDataDistance {

	private LabelData ld;

	private double distance;

	public LabelDataDistance(LabelData ld, double distance) {

		this.ld = ld;
		this.distance = distance;

	}

	public LabelData getLabelData() {
		return this.ld;
	}

	public double getDistance() {
		return this.distance;
	}

}
