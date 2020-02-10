package com.Ian.Algebra;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReadImage {
    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME);};
    public static void main(String[] args) {

       Mat source = Imgcodecs.imread("resource/lena.jpg");
       String outfile = "resource/lena.txt";
       List<Mat> brgList =new ArrayList<>();
       System.out.println(source.channels());
       System.out.println(source.cols());
       System.out.println(source.rows());
       Core.split(source,brgList);
       Date d1 = new Date();
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       System.out.println(sdf.format(d1));
      // System.out.println(brgList.get(0).dump());

       try {
            OutputStream out = new FileOutputStream(outfile);
            out.write(brgList.get(0).dump().getBytes());
            //out.write(source.dump().getBytes());
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Date d2 = new Date();
        System.out.println(sdf.format(d2));
        System.out.println((d2.getTime()-d1.getTime())/60000);
    }
}
