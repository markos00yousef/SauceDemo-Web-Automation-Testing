
package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String testName) {

        // Take screenshot from the browser
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Create screenshots/failed directory
        Path destination = Paths.get(
                "screenshots",
                "failed",
                testName + ".png"
        );

        try {

            // Create directory if it does not exist
            Files.createDirectories(destination.getParent());

            // Save screenshot
            Files.copy(
                    source.toPath(),
                    destination,
                    StandardCopyOption.REPLACE_EXISTING
            );

            return destination.toString();

        } catch (IOException e) {

            throw new RuntimeException("Failed to save screenshot", e);
        }
    }
}
