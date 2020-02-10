package com.Ian.Morphology;

import com.Ian.Utils.BasicFrame;
import com.Ian.Utils.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Erosion extends BasicFrame {
    public Erosion(int i) {
        super(i);
    }

    public static void main(String[] args) {


        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Erosion window = new Erosion(0);
                Mat dst = Utils.Erode(src,7,0);
                BufferedImage image = Utils.matToBufferImage(dst);
                window.setWindow(image,"Erosion");
                window.frame.setVisible(true);
            }
        });
    }
}
