package utilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


public class Screenshots {


	public static void takeScreenShot(WebDriver driver, String FailedCases) {

		String screenshotFileName = System.getProperty("user.dir") + "\\"+FailedCases+".jpg";
		File ssFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {

			FileUtils.copyFile(ssFile, new File(screenshotFileName));

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
	}


}
