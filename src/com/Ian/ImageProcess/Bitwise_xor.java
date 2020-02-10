package com.Ian.ImageProcess;

import com.Ian.Utils.Utils;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Bitwise_xor {
    JFrame frame ;
    static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);};
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Bitwise_xor window = new Bitwise_xor();
                window.frame.setVisible(true);
            }
        });

    }

    public Bitwise_xor()
    {
        initialize();
    }

    //TODO 比較Core.bitwise_xor 、Core.subtract、Core.bitwise_not 的差異
    //
    public void initialize(){
        frame = new JFrame();
        Mat src = Imgcodecs.imread("resource\\lena.jpg");
        Mat destination = new Mat(src.rows(),src.cols(),src.type(),new Scalar(255,0,0));
      // Mat destination = new Mat(src.rows(),src.cols(),src.type(),new Scalar(255 ,0,0));
        Mat dst = new Mat(src.rows(),src.cols(),src.type());
        Core.bitwise_xor(src,destination,dst);
        //Core.bitwise_and(src,destination,dst);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("影像");
        BufferedImage image = Utils.matToBufferImage(dst);
        frame.setBounds(100,100,src.rows()+100,src.cols()+100);
        frame.getContentPane().setLayout(null);
        JLabel label = new JLabel();
        label.setBounds(10,10,image.getHeight()+10,image.getWidth()+10);
        label.setIcon(new ImageIcon(image));
        frame.getContentPane().add(label);


    }
}
