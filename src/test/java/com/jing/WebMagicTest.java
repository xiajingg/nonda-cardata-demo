package com.jing;

import org.junit.Test;

import java.io.*;

public class WebMagicTest {


    @Test
    public void numtest(){
        try {
            File file=new File("aa");
            FileInputStream inputStream=new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("error==>"+e.getMessage()+"<==");
        }
    }
}