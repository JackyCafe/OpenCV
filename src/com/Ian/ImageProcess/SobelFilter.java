package com.Ian.ImageProcess;

import com.Ian.Utils.BasicFrame;
import com.Ian.Utils.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SobelFilter extends BasicFrame {

    public SobelFilter(int i) {
        super(0);
    }
    public SobelFilter(){
        super();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SobelFilter window = new SobelFilter(CvType.CV_8UC1);
            /*    Mat tmp = new Mat(src.rows(),src.cols(),src.type());
                Imgproc.cvtColor(src,tmp,Imgproc.COLOR_RGB2GRAY);
                Mat sobel = Utils.SobelFilter(tmp,1,0);*/
                Mat sobel = Utils.SobelFilter(src,1,0);
                BufferedImage image = Utils.matToBufferImage(sobel);
                window.setWindow(image,"SobelFilter");
                window.frame.setVisible(true);
            }
        });
    }
}
