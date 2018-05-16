package com.test;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class CMTest {

	@Test
	public void testA() {

		int n = 7;

		CombinationGroup cg = new CombinationGroup();

		Combination(cg, n);

		for (int i = 1; i <= n; i++) {

			ArrayList<CombinationData> al = cg.getCombinationGroup(i);
			dispCombinationData(al, "*");

		}

	}

	public void dispCombinationData(ArrayList<CombinationData> al, String splitChar) {

		if (al == null || al.size() <= 0)
			return;

		String s = "";

		for (int i = 0; i < al.size(); i++) {

			CombinationData cd = al.get(i);

			s = s + cd.toString(splitChar) + " ";

		}

		System.out.println(s);

	}

	public void Combination(CombinationGroup cg, int n) {

		for (int i = 1; i <= n; i++) {

			CombinationData cd = new CombinationData();
			cd.add(i);
			cg.addCombinationData(cd);

			Combination(cg, cd, n);

		}

	}

	public void Combination(CombinationGroup cg, CombinationData cd, int n) {

		int max = cd.getMax();

		if (max >= n)
			return;

		for (int k = max + 1; k <= n; k++) {

			CombinationData cdn = new CombinationData();
			for (Integer kk : cd.toArray()) {

				cdn.add(kk);

			}

			cdn.add(k);
			cg.addCombinationData(cdn);
			Combination(cg, cdn, n);
		}

	}

}

class CombinationGroup {

	HashMap<Integer, ArrayList<CombinationData>> hm = new HashMap<Integer, ArrayList<CombinationData>>();

	public CombinationGroup() {

	}

	public void addCombinationData(CombinationData cd) {

		ArrayList<CombinationData> al = hm.get(cd.getSize());

		if (al == null) {
			al = new ArrayList<CombinationData>();
			hm.put(cd.getSize(), al);
		}

		al.add(cd);

	}

	public ArrayList<CombinationData> getCombinationGroup(int size) {

		return hm.get(size);
	}

}

class CombinationData {

	private ArrayList<Integer> al = new ArrayList<Integer>();

	public CombinationData() {

	}

	public int getSize() {
		return al.size();
	}

	public void add(int num) {

		al.add(num);

	}

	public Integer[] toArray() {

		return al.toArray(new Integer[0]);

	}

	public int getMax() {

		return al.get(al.size() - 1);

	}

	public String toString(String splitChar) {

		Integer[] is = this.toArray();

		String st = "";

		boolean isFirst = true;

		for (int k : is) {

			if (isFirst) {
				st = st + String.valueOf(k);
				isFirst = false;
			} else {
				st = st + splitChar + String.valueOf(k);
			}
		}

		return st;

	}
}
