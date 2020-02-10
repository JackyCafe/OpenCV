package com.Ian.Convolution;

import com.Ian.Utils.BasicFrame;
import com.Ian.Utils.Utils;
import org.opencv.core.Mat;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MeanFilter extends BasicFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MeanFilter window = new MeanFilter();
                Mat dst = Utils.MeanFilter(src,15);
                BufferedImage image = Utils.matToBufferImage(dst);
                window.setWindow(image,"MeanFilter");
                window.frame.setVisible(true);
            }
        });
    }

}
