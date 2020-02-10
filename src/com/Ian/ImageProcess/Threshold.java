package com.Ian.ImageProcess;

import com.Ian.Utils.BasicFrame;
import com.Ian.Utils.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Threshold  extends BasicFrame {


    public Threshold(int cv8uc1) {
        super(cv8uc1);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Threshold window = new Threshold(CvType.CV_8UC1);
                Mat dst =  Utils.Threshold(src,125,255,0);
                BufferedImage image = Utils.matToBufferImage(dst);
                window.setWindow(image,"Threshold");
                window.frame.setVisible(true);
            }
        });
    }
}
