package com.aktog.yusuf.qahomework;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {

    WebDriver webDriver;

    @BeforeAll
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get("https://ebebek.com/");
        webDriver.manage().window().maximize();
    }

    @AfterAll
    public void tearDown(){
        webDriver.quit();
    }
}
