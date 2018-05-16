package com.cs.arithmetics;

public class EuclideanDistance {

	public static double distance(double[] x1, double[] x2) {

		double d = 0;

		for (int i = 0; i < x1.length; i++) {
			double x = x1[i] - x2[i];
			d = d + x * x;
		}

		return d;
	}
	
	public static double sqrtDistance(double[] x1, double[] x2) {

		double d = 0;

		for (int i = 0; i < x1.length; i++) {
			double x = x1[i] - x2[i];
			d = d + x * x;
		}

		return Math.sqrt(d);
	}

}
