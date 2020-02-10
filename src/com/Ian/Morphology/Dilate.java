package com.Ian.Morphology;

import com.Ian.Utils.BasicFrame;
import com.Ian.Utils.Utils;
import org.opencv.core.Mat;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Dilate extends BasicFrame {
    public Dilate(int i) {
        super(i);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Dilate window = new Dilate(0);
                Mat dst = Utils.Dilate(src,3,2);
                BufferedImage image = Utils.matToBufferImage(dst);
                window.setWindow(image,"Dilate");
                window.frame.setVisible(true);
            }
        });
    }
}
