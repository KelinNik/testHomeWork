package hw2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegressionTest {

    @DataProvider(parallel = true)
    public Object[][] dataForTest() {
        return new Object[][]{
                {"regression ", "test"}
        };
    }

    @Test(dataProvider = "dataForTest", groups = {"regression"})
    public void regressionTest1(String i, String s) {
        System.out.println(i + s);
    }

    @Test(groups = {"regression"})
    public void regressionTest2() {
        System.out.println("regression test");
    }
}