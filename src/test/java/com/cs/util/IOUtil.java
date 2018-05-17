package com.cs.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class IOUtil {

	public static void processCSVFile(String fileName, CSVProcess csvProc) throws FileNotFoundException, IOException {

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			reader.readLine();
			String line = null;
			while ((line = reader.readLine()) != null) {

				csvProc.processLine(line);

			}
		}

	}

}
