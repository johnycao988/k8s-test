package com.test;

import org.junit.Test;

public class X2 {
	
	@Test
	public void TestX2(){
	
		X2(1,5,-6);
	}
	
	
	public void X2(float a, float b, float c){
		
		String ss="方程 "+ a+"x^2+"+b+"x"+c;
		
		float bb=b*b-4*a*c;
		
		if((bb)<0){
			
			System.out.println(ss+" 无根！" );
			
			return;
			
		}
		
		double x1=(-b+Math.sqrt(bb))/2*a;
		double x2=(-b-Math.sqrt(bb))/2*a;
		
		System.out.println(ss+" 根是！"+x1+"," +x2);
		
		
	}
	
	
	

}
