package com.amazon.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class ChromiumDriver {

    private static final String CHROMEDRIVER_EXE = "chromedriver.exe";
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    private WebDriver driver;
    private ChromeDriverService service;

    public WebDriver run() {

        service = getChromeDriverService();
        driver = getWebDriver(service);
        try {
            service.start();
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return driver;
    }

    public void stop() {
        driver.close();
        service.stop();
    }

    private ChromeDriverService getChromeDriverService() {
        return new ChromeDriverService.Builder()
                .usingDriverExecutable(getChromeDriverFile())
                .usingAnyFreePort()
                .build();
    }

    private File getChromeDriverFile() {
        File chromeDriver = null;
        try {
            chromeDriver = new ClassPathResource(CHROMEDRIVER_EXE).getFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return chromeDriver;
    }

    private WebDriver getWebDriver(ChromeDriverService service) {
        return new ChromeDriver(service);
    }
}
