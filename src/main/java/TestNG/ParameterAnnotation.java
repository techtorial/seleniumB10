package TestNG;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterAnnotation {
    // using the xml file, we should pass parameter into the method.
    // THis connection will happen with Parameter annotation

        @Parameters("FirstName")
        @Test(priority = 2, invocationTimeOut = 2000)
        public void test(String name){
            System.out.println(name);
        }

        @Parameters({"City","State"})
        @Test(priority = 1, invocationCount = 5)
        public void test1(String city, String state){
            System.out.println(city);
            System.out.println(state);
        }


}
