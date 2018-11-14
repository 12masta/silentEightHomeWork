package com.szkolqa.biolerplate.tests


import com.szkolqa.boilerplate.testframework.driver.Driver
import com.szkolqa.boilerplate.testframework.listeners.screenshot.failure.ScreenshotListenerFinder
import com.szkolqa.boilerplate.testframework.pageobjects.login.LoginPageWebImpl
import org.openqa.selenium.WebDriver
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import spock.lang.Specification

//@RetryOnFailure(times = 3)
class BaseSpec extends Specification {
    public static String env = System.getProperty("env", "dev")
    public static String browser = System.getProperty("browser", "")
    private static Logger logger = LoggerFactory.getLogger(BaseSpec.class)
    protected WebDriver driver
    protected LoginPageWebImpl loginPage

    def setup() {
        setupDriver()
        activateScreenshotOnFailureListener()
        loginPage = new LoginPageWebImpl(driver)
    }

    def cleanup() {
        driver.quit()
    }

    def setupDriver() {
        driver = new Driver().initialize(browser, 10)
        driver.get(getConfig().url)
    }

    def activateScreenshotOnFailureListener() {
        ScreenshotListenerFinder.getListener(this).setDriver(driver)
    }

    def getConfig() {
        def config = new ConfigSlurper(env).parse(getClass().getResource("/config.groovy").toURI().toURL())
        logger.info("URL: " + config.url)
        config
    }
}
