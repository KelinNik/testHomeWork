package hw2;

import org.testng.annotations.Test;

public class SmokeRegressionTest {

    @Test(groups = {"smoke"})
    public void smokeTest3() {
        System.out.println("smoke test");
    }

    @Test(groups = {"regression"})
    public void regressionTest3() {
        System.out.println("regression test");
    }
}
