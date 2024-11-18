package tests.base;

import lombok.extern.log4j.Log4j2;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j2
public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Test " + result.getName() + " started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Test " + result.getName() + " success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info("Test  " + result.getName() + " failed");
    }

    @Override
    public void onStart(ITestContext context) {
        log.info("Test  " + context.getName() + " started");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("Test  " + context.getName() + " finished");
    }
}
