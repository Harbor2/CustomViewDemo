package com.example.customviewdemo;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: 王欲琢
 * @date: 2020/8/3 15:13
 * @desc:
 */
public class MyTest {
    @Test
    public void test1(){
        Date date = new Date();
        System.err.println("wyz "+ "获取时间信息 "+date);

        SimpleDateFormat dd = new SimpleDateFormat("dd");
        System.err.println("wyz "+ "获取时间信息 "+dd.format(date));

        SimpleDateFormat dd1 = new SimpleDateFormat("EEEE");
        System.err.println("wyz "+ "获取时间信息 "+dd1.format(date));

    }
}
