package com.testingfoo.grid;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumGridTest {

  private String hubUrl = "http://localhost:4444/wd/hub";

  private By loginBtn = By.tagName("button");
  private By username = By.id("username");
  private By password = By.id("password");
  private By message = By.id("flash");

  /* @Test
  public void testDesktop() throws MalformedURLException {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("browserName", "chrome");
//    caps.setCapability("browserVersion", "75");
    caps.setCapability("platformName", "MAC");

    RemoteWebDriver driver = new RemoteWebDriver(new URL(hubUrl), caps);
    actualTest(driver);
    driver.quit();
  } */

 /* @Test
  public void testIOS() {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("platformName", "iOS");
    caps.setCapability("platformVersion", "12.2");
    caps.setCapability("deviceName", "iPad Pro (9.7-inch)");
    caps.setCapability("browserName", "Safari");

    RemoteWebDriver driver = null;
    try {
      driver = new RemoteWebDriver(new URL(hubUrl), caps);
      actualTest(driver);
      driver.quit();
    } catch (Exception e) {
      if (driver != null) {
        driver.quit();
      }
    }
  } */

  @Test
  public void testIOS_2() {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("platformName", "iOS");
    caps.setCapability("platformVersion", "12.2");
    caps.setCapability("deviceName", "iPhone 8");
    caps.setCapability("browserName", "Safari");

    RemoteWebDriver driver = null;
    try {
      driver = new RemoteWebDriver(new URL(hubUrl), caps);
      actualTest(driver);
      driver.quit();
    } catch (Exception e) {
      if (driver != null) {
        driver.quit();
      }
    }
  } 

@Test
  public void testAndroid() throws MalformedURLException {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("platformName", "Android");
    caps.setCapability("deviceName", "dfa3b957");
    caps.setCapability("platformVersion", "9");
    caps.setCapability("automationName", "UiAutomator2");
    caps.setCapability("browserName", "Chrome");
//    caps.setCapability("avd", "Pixel_2_XL_API_27");

    RemoteWebDriver driver = null;
    try {
      driver = new RemoteWebDriver(new URL(hubUrl), caps);
      actualTest(driver);
      driver.quit();
    } finally {
      if (driver != null) {
        driver.quit();
      }
    }
  } 

 /*@Test
  public void testAndroid_2() throws MalformedURLException {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("platformName", "Android");
    caps.setCapability("deviceName", "Android Emulator");
    caps.setCapability("platformVersion", "9");
    caps.setCapability("automationName", "UiAutomator2");
    caps.setCapability("browserName", "Chrome");
//    caps.setCapability("avd", "Pixel_3_XL_API_28");

    RemoteWebDriver driver = null;
    try {
      driver = new RemoteWebDriver(new URL(hubUrl), caps);
      actualTest(driver);
      driver.quit();
    } finally {
      if (driver != null) {
        driver.quit();
      }
    }
  } */

  private void actualTest(RemoteWebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver, 10);

    String loginUrl = "https://the-internet.herokuapp.com/login";
    driver.navigate().to(loginUrl);
    wait.until(ExpectedConditions.presenceOfElementLocated(username))
            .sendKeys("foo");
    driver.findElement(password).sendKeys("bar");
    driver.findElement(loginBtn).click();

    String errText = wait.until(ExpectedConditions.presenceOfElementLocated(message)).getText();
    String ERR_MSG = "Your username is invalid!";

    Assert.assertTrue(errText.contains(ERR_MSG));
  }
}
