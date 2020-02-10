package com.Ian.ImageProcess;

import com.Ian.Utils.BasicFrame;
import com.Ian.Utils.Utils;
import org.opencv.core.Mat;

import java.awt.*;
import java.awt.image.BufferedImage;

public class NormalizedBlur extends BasicFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                NormalizedBlur window = new NormalizedBlur();
                Mat dst = Utils.NormalizeBlur(src,51);
                BufferedImage image = Utils.matToBufferImage(dst);
                window.setWindow(image,"NormalizedBlur");
                window.frame.setVisible(true);

            }
        });
    }
}
