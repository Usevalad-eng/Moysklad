package tests.base;

import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j2
public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.printf("Test  %S started %n", result.getName());
        log.info("Test " + result.getName() + " started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.printf("Test  %S success %n", result.getName());
        log.info("Test " + result.getName() + " success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.printf("Test  %S failed %n", result.getName());
        log.info("Test  " + result.getName() + " failed");
    }

    /*@Override
    public void onStart(ITestContext context) {
        log.info("Test  " + context.getName() + " started");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("Test  " + context.getName() + " finished");
    }*/
}
