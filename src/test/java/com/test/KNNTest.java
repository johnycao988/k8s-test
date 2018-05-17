package com.test;

import org.junit.Test;

 
import com.cs.ai.data.DataSet;
import com.cs.ai.data.Labels; 

public class KNNTest {

	@Test
	public void testKNN() {

		try {

			Labels labels = new Labels();
			
		 	labels.addLabel("Sex", Labels.TYPE_STR);
			labels.addLabel("Age", Labels.TYPE_NUMS);
			labels.addLabel("Nationality", Labels.TYPE_STR);
			labels.addLabel("City", Labels.TYPE_STR);
			labels.addLabel("Eyes", Labels.TYPE_STR);
			labels.addLabel("Skin", Labels.TYPE_STR);
			labels.addLabel("Height", Labels.TYPE_NUMS);
			labels.addLabel("Education", Labels.TYPE_STR);
			
			String csvFile = KNNTest.class.getResource("/knn.test.cs").getFile();

			DataSet ds = new DataSet(labels);

			ds.loadCSVFile(csvFile, true);
			
			ds.printToConsole();
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
