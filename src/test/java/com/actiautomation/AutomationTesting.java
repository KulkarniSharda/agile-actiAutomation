package com.actiautomation;

public class AutomationTesting {
     public static void main(String arg){
       //  SoftwareTesting var1;
        // SoftwareTesting var2;
         SoftwareTesting testing=(var1 , var2)->{
             System.out.println("this is a selenium  method from SoftwareTesting interface");
             return "Returned Value";

         };
         System.out.println(testing.selenium("java", 17));
     }
}
