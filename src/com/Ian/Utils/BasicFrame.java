package com.Ian.Utils;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.image.BufferedImage;

public class BasicFrame {
    public JFrame frame;
    static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}
    public static  Mat src ;
    public  BasicFrame()
    {
        src = Imgcodecs.imread("resource\\lena.jpg");

    }

    public  BasicFrame(int type)
    {
         src = Imgcodecs.imread("resource\\lena.jpg",type);


    }
    public void setWindow(BufferedImage image,String title){
        frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(title);

        frame = new JFrame();
        frame.setTitle(title);
        frame.setBounds(100, 100, image.getWidth()+100, image.getHeight()+100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        JLabel label = new JLabel("");
        label.setBounds(10,10,image.getHeight(),image.getWidth());
        label.setIcon(new ImageIcon(image));
        frame.getContentPane().add(label);

    }


}
