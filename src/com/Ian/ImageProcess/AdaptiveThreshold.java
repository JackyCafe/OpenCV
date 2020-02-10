package com.Ian.ImageProcess;

import com.Ian.Utils.BasicFrame;
import com.Ian.Utils.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.image.BufferedImage;

public class AdaptiveThreshold extends BasicFrame {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Threshold window = new Threshold(CvType.CV_8UC1);
                Mat dst =  Utils.AdaptiveThreshold(src,33,300,0,0);
                BufferedImage image = Utils.matToBufferImage(src);
                window.setWindow(image,"Threshold");
                window.frame.setVisible(true);

                final JLabel showAlphaValue = new JLabel("1");
                showAlphaValue.setBounds(260, 10, 40, 15);
                window.frame.getContentPane().add(showAlphaValue);

                final JLabel showBetaValue = new JLabel("1");
                showBetaValue.setBounds(256, 35, 29, 15);
                window.frame.getContentPane().add(showBetaValue);

                final JLabel lblNewLabel = new JLabel("");
                lblNewLabel.setBounds(10, 68, 438, 438);
                lblNewLabel.setIcon(new ImageIcon(image));
                window.frame.getContentPane().add(lblNewLabel);

                final JSlider slider_Maxval = new JSlider();
                slider_Maxval.setMinimum(1);
                slider_Maxval.setValue(1);
                slider_Maxval.setMaximum(300);
                slider_Maxval.setBounds(67, 33, 185, 25);
                window.frame.getContentPane().add(slider_Maxval);

                final JSlider slider_AdaptiveMethod = new JSlider();
                slider_AdaptiveMethod.setMaximum(1);
                slider_AdaptiveMethod.setValue(0);
                slider_AdaptiveMethod.setBounds(380, 10, 46, 25);
                window.frame.getContentPane().add(slider_AdaptiveMethod);


                final JSlider slider_blockSize = new JSlider();
                slider_blockSize.setMinimum(3);
                slider_blockSize.setMaximum(901);
                slider_blockSize.setValue(3);

                slider_blockSize.setBounds(67, 10, 192, 25);
                window.frame.getContentPane().add(slider_blockSize);

                JLabel lblThresh = new JLabel("blockSize");
                lblThresh.setBounds(10, 20, 58, 15);
                window.frame.getContentPane().add(lblThresh);

                JLabel lblMaxval = new JLabel("Maxval");
                lblMaxval.setBounds(10, 45, 46, 15);
                window.frame.getContentPane().add(lblMaxval);

                JLabel lblAdaptiveMethod = new JLabel("adaptiveMethod");
                lblAdaptiveMethod.setBounds(291, 10, 93, 15);
                window.frame.getContentPane().add(lblAdaptiveMethod);

                final JLabel showAdaptiveMethodValue = new JLabel("0");
                showAdaptiveMethodValue.setBounds(429, 25, 19, 15);
                window.frame.getContentPane().add(showAdaptiveMethodValue);

                JLabel lblNewLabel_1 = new JLabel("type");
                lblNewLabel_1.setBounds(306, 50, 46, 15);
                window.frame.getContentPane().add(lblNewLabel_1);

                final JSlider slider_Type = new JSlider();

                slider_Type.setValue(0);
                slider_Type.setMaximum(1);
                slider_Type.setBounds(402, 25, 46, 25);
                window.frame.getContentPane().add(slider_Type);

                final JLabel showTypeValue = new JLabel("0");
                showTypeValue.setBounds(402, 50, 46, 15);
                window.frame.getContentPane().add(showTypeValue);

                slider_blockSize.addChangeListener(new ChangeListener() {
                    public void stateChanged(ChangeEvent arg0) {
                        //System.out.println(slider_alpha.getValue());
                        if(slider_blockSize.getValue()%2==0){
                            slider_blockSize.setValue(slider_blockSize.getValue()+1);
                        }

                        showAlphaValue.setText(slider_blockSize.getValue()+"");
                        BufferedImage newImage=Utils.matToBufferImage(Utils.AdaptiveThreshold(src,slider_blockSize.getValue(),slider_Maxval.getValue(),slider_AdaptiveMethod.getValue(),slider_Type.getValue()));
                        lblNewLabel.setIcon(new ImageIcon(newImage));
                    }
                });

                slider_Maxval.addChangeListener(new ChangeListener() {
                    public void stateChanged(ChangeEvent arg0) {
                        //System.out.println(slider_alpha.getValue());
                        showBetaValue.setText(slider_Maxval.getValue()+"");
                        BufferedImage newImage=Utils.matToBufferImage(Utils.AdaptiveThreshold(src,slider_blockSize.getValue(),slider_Maxval.getValue(),slider_AdaptiveMethod.getValue(),slider_Type.getValue()));
                        lblNewLabel.setIcon(new ImageIcon(newImage));
                    }
                });
            }
        });
    }
}
