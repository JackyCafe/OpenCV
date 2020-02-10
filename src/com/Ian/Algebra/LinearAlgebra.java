package com.Ian.Algebra;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;

import java.sql.SQLOutput;

public class LinearAlgebra {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat m1 = new Mat(2, 2, CvType.CV_32FC1);
        m1.put(0,0,0);
        m1.put(0,1,1);
        m1.put(1,0,2);
        m1.put(1,1,3);
        System.out.println(m1.dump());
        Mat m2 =  m1.clone();
        System.out.println("複製:"+m2.dump());
        Mat m3 = new Mat();
        Core.add(m1,m2,m3);
        System.out.println("相加:"+m3.dump());
        Mat m4 = new Mat();
        Core.subtract(m3,m1,m4);
        System.out.println("相減:"+m4.dump());
        Mat m5 = new Mat();
        Core.gemm(m1,m2,1,new Mat(),0,m5);
        System.out.println("m5矩陣相乘"+m5.dump());
        Mat m6 =   m1.mul(m2);
        System.out.println("m6 元素內相乘"+m6.dump());
        Mat m7 = new Mat(2,2,CvType.CV_32F);
        Core.multiply(m1,m2,m7);
        System.out.println("m7 元素內相乘 "+m6.dump());
        Mat m8 = new Mat(2,2,CvType.CV_32F,new Scalar(3));
        Mat m9 = m1.mul(m8);
        System.out.println("m9:元素內乘3" + m9.dump());

    }
     //



}
