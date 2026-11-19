
package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;

public class TestListener implements ITestListener {

    private static final Logger logger =
            LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {

        String testName = result.getMethod().getMethodName();

        logger.info("================================================================================================");
        logger.info("TEST STARTED: " + testName);
        logger.info("================================================================================================");
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        String testName = result.getMethod().getMethodName();

        logger.info("================================================================================================");
        logger.info("TEST PASSED: " + testName);
        logger.info("================================================================================================");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        Object testInstance = result.getInstance();

        WebDriver driver = ((BaseTest) testInstance).getDriver();

        String testName = result.getMethod().getMethodName();

        logger.error("================================================================================================");
        logger.error("TEST FAILED: " + testName);
        logger.error("Failure Reason: " + result.getThrowable());

        if (driver != null) {

            try {

                String screenshotPath =
                        ScreenshotUtil.takeScreenshot(driver, testName);

                logger.info("Screenshot saved: " + screenshotPath);

            } catch (Exception e) {

                logger.error("Failed to save screenshot", e);
            }
        }

        logger.error("================================================================================================");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        String testName = result.getMethod().getMethodName();

        logger.warn("================================================================================================");
        logger.warn("TEST SKIPPED: " + testName);
        logger.warn("================================================================================================");
    }
}
