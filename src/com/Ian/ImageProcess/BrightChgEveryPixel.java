package com.Ian.ImageProcess;

import com.Ian.Utils.Utils;
import com.sun.deploy.panel.RuleSetViewerDialog;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BrightChgEveryPixel {
    static double alpha = 1;
    static double beta = 20;
    private JFrame frame ;

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);


        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                BrightChgEveryPixel window = new BrightChgEveryPixel();
                window.frame.setVisible(true);
            }
        });


    }

    public  BrightChgEveryPixel(){
        frame = new JFrame();
        Mat source = Imgcodecs.imread("resource\\lena.jpg",Imgcodecs.IMREAD_COLOR);
        Mat dst = matConvertTo(source,alpha,beta);
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




    private static  Mat matConvertTo(Mat src,double alpha,double beta)
    {
        Mat dest = new Mat(src.rows(),src.cols(),Imgcodecs.IMREAD_COLOR);
        for ( int j=0;j<src.rows();j++ )
        {
            for (int i=0;i<src.cols();i++)
            {
                double[] tmp = src.get(j,i);
                tmp[0] =tmp[0]*alpha+beta;
                tmp[1] =tmp[1]*alpha+beta;
                tmp[2] =tmp[2]*alpha+beta;
                dest.put(j,i,tmp);
            }
        }
        return dest;
    }


}

