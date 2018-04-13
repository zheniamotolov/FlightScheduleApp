//package com.demo.coursework.activates.airportActivity;
//
//import android.os.Build;
//import android.support.annotation.RequiresApi;
//
///**
// * Created by eugene on 4/13/18.
// */
//
//public class Main {
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    public static void main(String[] args) {
//        System.out.println(digPow(92, 1));
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.N)
//    public static long digPow(int n, int p) {
//        int[] ints = Integer.toString(n).chars().map(c -> c -= '0').toArray();
//        float i = 0;
//        float sum = 0;
//
//        for (int ch : ints) {
//            sum += Math.pow(ch, i + p);
//            i++;
//        }
//
//        float reult = sum / n;
//        if (reult == Math.ceil( reult)) {
//            return (long)reult;
//        }
//        return -1;
//a\
//
//    }
//}
