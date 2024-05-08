package com.actiTestAutomation;

import org.testng.annotations.Test;

public class SampleAttributeTest {
    @Test(priority = 1, enabled = false)
    public void login(){
        System.out.println("This is login method....");
    }
    @Test(priority = 2, description = "add task using valid details")
    public void addTask(){
        System.out.println("This is addTask method");
    }
    @Test(priority = 3, timeOut = 5)
    public void logout() throws InterruptedException{
        System.out.println("This is logout method.....");

        int [][]a=new int[2][2];
        a[0][0]=1;
        a[0][1]=2;
        a[1][0]=3;
        a[1][1]=4;
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a.length; j++){
                System.out.println(a[i][j]);
            }
        }
        int [][] b=new int[][]{
                {1,2},
                {3,4},
                {5, 6}
        };
        System.out.println("Row length:"+b.length);
        System.out.println("column length: "+b[1].length);
        for(int i=0; i<b.length; i++){
            for(int j=0; j<b[0].length; j++){
                System.out.println(b[i][j]);

            }

        }

        String [][] c=new String[][]{
                {"1", "2"},
                {"3","4"},
                {"5","6"}
        };
        Object [][] d=new Object[][]{
                {"1",2},
                {3.3, true},
                {'a', 12.120000}
        };
    }
}
