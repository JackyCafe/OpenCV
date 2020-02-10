package com.Ian.ImageProcess;

import com.Ian.Utils.BasicFrame;
import com.Ian.Utils.Utils;
import org.opencv.core.Mat;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BoxFlur extends BasicFrame {



    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                BoxFlur window = new BoxFlur();
                Mat dst = Utils.BoxFilterBlur(src,5);
                BufferedImage image = Utils.matToBufferImage(dst);

                window.setWindow(image,"BoxFlur");
                window.frame.setVisible(true);
            }
        });
    }


}
