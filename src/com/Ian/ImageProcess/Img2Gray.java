package com.Ian.ImageProcess;

import com.Ian.Utils.Utils;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Img2Gray {
    static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}
    static JFrame frame ;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Img2Gray window = new Img2Gray();
                window.frame.setVisible(true);
            }
        });
    }

    public Img2Gray(){
        initialize();

    }

    private void initialize() {
       frame = new JFrame();
       Mat src = Imgcodecs.imread("resource/lena.jpg");
       Mat dst = new Mat(src.rows(),src.cols(),src.type());
       Imgproc.cvtColor(src,dst,Imgproc.COLOR_RGB2GRAY);
       BufferedImage image = Utils.matToBufferImage(dst);
        frame.setTitle("讀取影像");
        frame.setBounds(100,100,image.getHeight()+100,image.getWidth()+100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        JLabel label= new JLabel("");
        label.setBounds(10,10,image.getHeight()+10,image.getWidth()+10);
        label.setIcon(new ImageIcon(image));
        frame.getContentPane().add(label);
    }


}
