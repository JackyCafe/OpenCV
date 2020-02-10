package com.Ian.ImageProcess;

import com.Ian.Utils.BasicFrame;
import com.Ian.Utils.Utils;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MedianBlur extends BasicFrame {
    static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);};

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Mat src = Imgcodecs.imread("resource\\lena.jpg");
                Mat dst = Utils.MedianBlurFilter(src,9);
                BufferedImage image = Utils.matToBufferImage(dst);
                MedianBlur window = new MedianBlur();
                window.setWindow(image,"MedianBlur");
                window.frame.setVisible(true);
            }
        });
    }




}
