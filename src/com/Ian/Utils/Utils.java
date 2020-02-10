package com.Ian.Utils;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import java.awt.image.BufferedImage;

public class Utils {
    Mat src;
    public  Utils(){ };
    public  Utils(Mat src){this.src = src;}
    public static BufferedImage matToBufferImage(Mat matrix){
        int cols = matrix.cols();
        int rows = matrix.rows();
        //img1.elemSize() = 3 (每一個元素包含3個uchar值), img1.elemSize1() = 1 (elemSize/channels);
        // 矩陣中每一個元素的數據大小，如果Mat中的數據類型是CV_8U，則elemSize=1，若是CV_8UC3則elemSize=3，若是CV_16UC2則eleSize=4。
        int elemSize= (int) matrix.elemSize();

        byte[] data=  new byte[cols*rows*elemSize];
        int type;
        matrix.get(0,0,data);
        switch ( matrix.channels()){
            case 1: type=BufferedImage.TYPE_BYTE_GRAY;
                break;
            case 3: type =BufferedImage.TYPE_3BYTE_BGR;
                byte b;
                //bgr to rgb
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

    /** Median 中值模糊處理
     * */
    public static Mat MedianBlurFilter(Mat src,int apertureLinearSize){
        Mat dst = new Mat(src.rows(),src.cols(),src.type());
        Imgproc.medianBlur(src,dst,apertureLinearSize);
        return dst;
    }

    /** 高斯模糊化處理
     *
     */

    public static Mat GaussianBlurFilter(Mat src,int kernalSize)
    {
        Mat dst = new Mat(src.rows(),src.cols(),src.type());
        Imgproc.GaussianBlur(src,dst,new Size(kernalSize,kernalSize),0,0);
        return dst;
    }

    public static Mat BoxFilterBlur(Mat src,int KSize)
    {
        Mat dst = new Mat(src.rows(),src.cols(),src.type());
        Imgproc.boxFilter(src,dst,-1,new Size(KSize,KSize));
        return dst;
    }

    public static Mat  NormalizeBlur(Mat src,int KSize)
    {
        Mat dst = new Mat(src.rows(),src.cols(),src.type());
        Imgproc.blur(src,dst,new Size(KSize,KSize));
        return dst;
    }


    /**
     *
     * @param src  影像來源Mat
     * @param thresh 切斷值
     * @param maxval 只有type 為THRESH_BINARY和THRESH_BINARY_INV 有影響
     * @param type 0-4
     * THRESH_BINARY = 0，大於thresh 時，則為最大值，不然為0
     * THRESH_BINARY_INV = 1，大於thresh 時，則為0，不然為最大值
     * THRESH_TRUNC = 2 大於 thresh，設為thresh，小於的值不變
     * THRESH_TOZERO = 3 小於thresh，設為0，大於的值不變
     * THRESH_TOZERO_INV = 4 大於thresh，設為0，小於的值不變
     * @return 傳回mat
     */
    public static Mat Threshold(Mat src,double thresh,double maxval,int type)
    {
        Mat dst = new Mat(src.rows(),src.cols(),src.type());
        Imgproc.threshold(src,dst,thresh,maxval,type);
        return dst;
    }



    public static Mat AdaptiveThreshold(Mat src,int blockSize,double maxval,int adaptiveMethod,int type){
        Mat dst = new Mat(src.rows(),src.cols(),src.type());
        Imgproc.adaptiveThreshold(src,dst,maxval,adaptiveMethod,type,blockSize,0);
        return dst;
    }


    /**
     *
      * @param src
     * @param KernelSize
     * @return
     */
    public static Mat MeanFilter(Mat src,int KernelSize){
        Mat kernel = Mat.ones(KernelSize,KernelSize, CvType.CV_32F);
        for (int i =0;i<kernel.rows();i++)
        {
            for ( int j=0;j<kernel.cols();j++){
                double [] tmp = kernel.get(i,j);
                tmp[0] = tmp[0]/(KernelSize*KernelSize);
                kernel.put(i,j,tmp);
            }
        }
        Mat dst =new Mat(src.rows(),src.cols(),src.type());
        Imgproc.filter2D(src,dst,-1,kernel);
        return dst;
    }


    /**
     *
     * @param src
     * @param type type=1 ,垂直。 type=2 水平
     * @return
     */
    public static Mat PreWittFilter(Mat src,int type){
        Mat kernel = new Mat(3,3,CvType.CV_32F);
        if(type ==1){
            kernel.put(0,0,new float[]{-1,0,1});
            kernel.put(1,0,new float[]{-1,0,1});
            kernel.put(2,0,new float[]{-1,0,1});
        }else if(type == 2){
            kernel.put(0,0,new float[]{-1,-1,-1});
            kernel.put(1,0,new float[]{0,0,0});
            kernel.put(2,0,new float[]{1,1,1});
        }else if(type==3){
            kernel.put(0,0,new float[]{0,1,0});
            kernel.put(1,0,new float[]{1,-4,1});
            kernel.put(2,0,new float[]{0,1,0});
        }else if(type==4){
            kernel.put(0,0,new float[]{0,-1,0});
            kernel.put(1,0,new float[]{-1,4,-1});
            kernel.put(2,0,new float[]{0,-1,0});
        }else if(type==5) {
            kernel.put(0, 0, new float[]{1, 1, 1});
            kernel.put(1, 0, new float[]{1, -8,1 });
            kernel.put(2, 0, new float[]{1, 1, 1});
        }else if(type==6) {
            kernel.put(0, 0, new float[]{-1, 2, -1});
            kernel.put(1, 0, new float[]{2, -4, 2});
            kernel.put(2, 0, new float[]{-1, 2, -1});
        }
        Mat dst = new Mat(src.rows(),src.cols(),src.type());
        Imgproc.filter2D(src,dst,-1,kernel);
        return dst;
    }

    /**
     *
     * @param src
     * @param dx
     * @param dy
     * @return
     */
    public static Mat SobelFilter(Mat src,int dx,int dy){
        Mat dst = new Mat(src.rows(),src.cols(),src.type());
        if ((dx==0)&&(dy==0))
        {dx=1;}
        Imgproc.Sobel(src,dst,-1,dx,dy);
        return dst;
    }

    public static Mat Erode(Mat src,int ksize,int shape){
        Mat dst = new Mat(src.rows(),src.cols(),src.type());
        Mat element = Imgproc.getStructuringElement(shape,new Size(2*ksize+1,2*ksize+1));
        Imgproc.erode(src,dst,element);
        return dst;
    }


    public static Mat Dilate(Mat src,int ksize,int shape)
    {
        Mat dst = new Mat(src.rows(),src.cols(),src.type());
        Mat element = Imgproc.getStructuringElement(shape,new Size(2*ksize+1,2*ksize+1));
        Imgproc.dilate(src,dst,element);
        return dst;
    }

    public static Mat Canny(Mat src, double th1, double th2)
    {
        Mat dst = new Mat(src.rows(),src.cols(),src.type());
        Imgproc.Canny(src,dst,th1,th2);
        return dst;
    }
}
