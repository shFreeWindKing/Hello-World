package com.shptchangfeng.eastdemo;

import lombok.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

@ToString(of = {"code","name","sex"}, exclude = {"age"})
@EqualsAndHashCode
@Data
@SpringBootTest
public class LombokTest implements Cloneable{
    @NonNull
    private String code;
    @NonNull
    private String name;
    private int age;
    private String sex;

    @Override
    protected LombokTest clone() {
        LombokTest clone = null;
        try {
            clone = (LombokTest) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return clone;
    }

    @Test
    @SneakyThrows
    public void printFile() {
        String sname = "D:/SAAS_Git/test/file/sysconfig.properties";
        File file = new File(sname);
        @Cleanup
        InputStream inputStream = new FileInputStream(file);
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        System.out.println("=============FileInputStream==================");

    }

    @SneakyThrows
    public void printFile2() {
        String sname = "D:/SAAS_Git/test/file/sysconfig.properties";
        FileReader fr = new FileReader(sname);
        BufferedReader bf = new BufferedReader(fr);
        String str;
        // 按行读取字符串
        while ((str = bf.readLine()) != null) {
            System.out.println(str);
        }
        System.out.println("=============BufferedReader==================");
    }


    public static void main(String[] args) {
        LombokTest studentA = new LombokTest("202001","张三");
        studentA.setAge(23);
        studentA.setSex("男");
        LombokTest studentC = null;

        studentC = (LombokTest) studentA.clone();

        LombokTest studentB = new LombokTest("202002","李四");
        studentB.setSex("女");
        studentB.setAge(30);
        boolean isEqual = studentA.equals(studentB);
        System.out.println("A:" + studentA.toString() + ";B:" +studentB.toString() + ";" + (isEqual ? "同一人" : "不是同一人"));
        isEqual = studentA.equals(studentC);
        System.out.println("A:" + studentA.toString() + ";C:" +studentC.toString() + ";" + (isEqual ? "同一人" : "不是同一人"));

        //test read file
        studentA.printFile();
        studentA.printFile2();
    }
}
