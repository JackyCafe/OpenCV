package com.Ian.Algebra;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class Transpose {
	static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}

	public static void main(String[] args) {
		 Mat m1 = new Mat(2, 2, CvType.CV_8UC1);
		 m1.put(0,0,0);
		 m1.put(0,1,1);
		 m1.put(1,0,2);
		 m1.put(1,1,3);
		 System.out.println("m1 所有元素"+m1.dump());
		 System.out.println("m1 轉置矩陣"+m1.t().dump());
	}
}
