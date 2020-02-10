package com.Ian.ImageProcess;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Brightness {
    static double alpha = 2 ;
    static double beta = 20;
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat source = Imgcodecs.imread("resource\\lena.jpg",Imgcodecs.IMREAD_COLOR);
        Mat dst = new Mat(source.rows(),source.cols(),source.type());
        source.convertTo(dst,-1,alpha,beta); //
        Imgcodecs.imwrite("resource\\bright_lena.jpg",dst);

    }
}
