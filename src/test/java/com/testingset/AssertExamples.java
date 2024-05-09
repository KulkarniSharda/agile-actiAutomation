package com.testingset;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertExamples {
    @Test
    public void test() throws Exception {
        String val1 = "cyber success";

        String val2 = "cyber";
        /* if(val1!=val2){
        throw new Exception ("values are not matching");
         */


        //Soft Assertion
        SoftAssert assertion = new SoftAssert();
        //compare two string values

        assertion.assertEquals(val1, val2);
        boolean flag1=true;
        boolean flag2=false;
        //compare two boolean value
        assertion.assertEquals(flag1, flag2);
        boolean flag3=false;
        //check if given value written true result
        assertion.assertTrue(flag3);
        //Hard Assertion;
        //Assert.assertEquals(actualvalue, expectedValue);
        //Assert.assertEquals(val1, val2);
        //Assert.assertEquals(val1, val2, "both strings are not matching");
        //Assert.assertTrue(flag3);
        Assert.assertTrue(flag3,"flag3 value is not true");


    }
}
