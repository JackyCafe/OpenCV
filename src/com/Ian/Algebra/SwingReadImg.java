package com.Ian.Algebra;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SwingReadImg {
    static  {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}
    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
              try {
                  SwingReadImg window = new SwingReadImg();
                  window.frame.setVisible(true);
              }catch (Exception e){
                  for(StackTraceElement s: e.getStackTrace())
                  {System.out.println(s.toString());}
              }

            }
        });
    }
    public  SwingReadImg(){
        initialize();
    }
    public void initialize(){
        frame = new JFrame();
        Mat source = Imgcodecs.imread("resource\\lena.jpg");
        BufferedImage image = mat2BufferedImage(source);
        frame.setTitle("讀取影像");
        frame.setBounds(100,100,image.getHeight()+100,image.getWidth()+100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        JLabel label= new JLabel("");
        label.setBounds(10,10,image.getHeight()+10,image.getHeight()+10);
        label.setIcon(new ImageIcon(image));
        frame.getContentPane().add(label);
    }

    private BufferedImage mat2BufferedImage(Mat matrix) {
        int cols = matrix.cols();
        int rows = matrix.rows();
        int elemSize= (int) matrix.elemSize();
        byte[] data=  new byte[cols*rows*elemSize];
        int type;
        matrix.get(0,0,data);
        switch ( matrix.channels()){
            case 1: type=BufferedImage.TYPE_BYTE_GRAY;
                    break;
            case 3: type =BufferedImage.TYPE_3BYTE_BGR;
                    byte b;
                    for (int i=0;i<data.length;i+=3)
                    {
                        b = data[i];
                        data[i]=data[i+2];
                        data[i+2] = b;
                    }
                    break;
            default: return null;
        }
        BufferedImage image2= new BufferedImage(cols,rows,type);
        image2.getRaster().setDataElements(0,0,cols,rows,data);
        return image2;
    }
}
