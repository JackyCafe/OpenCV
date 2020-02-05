package com.Ian.Morphology;

import com.Ian.Utils.BasicFrame;
import com.Ian.Utils.Utils;
import org.opencv.core.Mat;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Canny extends BasicFrame {
    public Canny(int i) {
        super(i);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Canny window = new Canny(0);
                Mat dst = Utils.Canny(src,222,337);
                BufferedImage image = Utils.matToBufferImage(dst);
                window.setWindow(image,"Dilate");
                window.frame.setVisible(true);
            }
        });
    }
}
