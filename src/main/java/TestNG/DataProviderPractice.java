package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DataProviderPractice {

    @Test(dataProvider = "NameTest", dataProviderClass = Data.class)
    public void test(String name, String lastName, String expected){
        String fname=name;
        String lname=lastName;
        String fullName=fname+" "+lname;
        Assert.assertEquals(fullName,expected);
    }

}
