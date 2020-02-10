package com.Ian.ImageProcess;

import com.Ian.Utils.BasicFrame;
import com.Ian.Utils.Utils;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GaussianBlur extends BasicFrame {
    static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);};

    public static void main(String[] args) {
        Mat src = Imgcodecs.imread("resource\\lena.jpg");

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GaussianBlur window = new GaussianBlur();
                Mat dst = Utils.GaussianBlurFilter(src,11);
                BufferedImage image = Utils.matToBufferImage(dst);
                window.setWindow(image,"GaussianBlur");
                window.frame.setVisible(true);
            }
        });
    }


}
