package softassertpr;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertIntro {
    public int getSum(int num1, int num2){
        return num1+num2;
    }
    // 2+ 6=8
    // 0 +0 = 0
    // -1 + -6= -7
    // 5 + -3= 2
    @Test
    public void test(){

        Assert.assertEquals(getSum(2,6), 8);
        System.out.println("test1");
        Assert.assertEquals(getSum(0,0),1);
        System.out.println("test2");
        Assert.assertEquals(getSum(-1,-6),-7);
        System.out.println("test3");
        Assert.assertEquals(getSum(5,-3),2);
        System.out.println("test4");
    }

    @Test
    public void softTest(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(getSum(2,6),8);
        System.out.println("test1");
        softAssert.assertEquals(getSum(0,0),1);
        System.out.println("test2");
        softAssert.assertEquals(getSum(-1,-6),-7);
        System.out.println("test3");
        softAssert.assertEquals(getSum(5,-3),3);
        System.out.println("test4");
        softAssert.assertAll("Soft assert failed");
    }
}
