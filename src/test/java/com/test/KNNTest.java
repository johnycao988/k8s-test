package com.test;

import org.junit.Test;

import com.cs.arithmetics.EuclideanDistance;
import com.cs.arithmetics.KNN;
import com.cs.data.LabelDataSet;

public class KNNTest {
	
	@Test
	public void testKNN(){
		
		LabelDataSet lds=new LabelDataSet();
		
		double[] d={1,2,3};
		
		lds.addLabelData(d,"m0");
		
		double[] d1={2,3,4};
		lds.addLabelData(d1,"m1");

		double[] d2={13,3,2};
		lds.addLabelData(d2,"m2");

		double[] d3={4,1,2};
		lds.addLabelData(d3,"m3");

		double[] d4={17,4,2};
		lds.addLabelData(d4,"m4");
		
		double[] d5={1,2,3};
		lds.addLabelData(d5,"m5");
		
		double[] d6={1,4,2};
		lds.addLabelData(d6,"m6");
		
		double[] td={1,2,3};

		KNN.getLabel(td, lds, 1);
	
	}

}


