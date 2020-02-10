package com.company;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat m1 = new Mat(3, 3, CvType.CV_32FC1);

        m1.put(0,0,0);
        m1.put(0,1,1);
        m1.put(1,0,2);
        m1.put(1,1,3);

        Mat invert = new Mat();
        Core.invert(m1,invert);

        System.out.println("m1 行數"+ m1.cols());
        System.out.println("m1 列數"+ m1.rows());
        System.out.println("所有元素個素"+m1.total());
        System.out.println("size"+m1.size());
        System.out.println(m1.dump());
        System.out.println("===轉置矩陣=====");
        System.out.println(m1.t().dump());
        System.out.println("===反矩陣=====");
        System.out.println(invert.dump());
    }
}
