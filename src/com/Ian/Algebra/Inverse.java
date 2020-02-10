package com.Ian.Algebra;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class Inverse {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat m1 = new Mat(2,2,CvType.CV_32FC1);
		 m1.put(0,0,0);
		 m1.put(0,1,1);
		 m1.put(1,0,2);
		 m1.put(1,1,3);
		 System.out.print(m1.dump());
		 System.out.println();
		 System.out.print(m1.t().dump());
		 Mat invert = new Mat();
		 System.out.println();
		 Core.invert(m1,invert);
		 System.out.print(invert.dump());
		System.out.println();
		Mat m2 =  m1.inv();
		System.out.println(m2.dump());
	}
}
