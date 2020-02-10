package com.Ian.ImageProcess;

import com.Ian.Utils.BasicFrame;
import com.Ian.Utils.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Prewitt extends BasicFrame {

   public Prewitt(){}
    public Prewitt(int i) {
        super(0);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Prewitt window = new Prewitt();
                Mat tmp =  new Mat(src.rows(),src.cols(),src.type());
                Mat dst =  new Mat(src.rows(),src.cols(),src.type());
                Imgproc.cvtColor(src,tmp,Imgproc.COLOR_RGB2GRAY);
                dst = Utils.Threshold(tmp,128,255,0);
                dst = Utils.PreWittFilter(dst,4);
                BufferedImage image =Utils.matToBufferImage(dst);
                window.setWindow(image,"Prewitt");
                window.frame.setVisible(true);
            }
        });


    }
}
