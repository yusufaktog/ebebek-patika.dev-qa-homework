package com.aktog.yusuf.qahomework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;

import java.time.Duration;

public class EbebekUITest extends BaseTest {

    @Test
    @Order(1)
    public void doSearch() {

        WebElement searchBox = webDriver.findElement(By.id("txtSearchBox"));
        searchBox.sendKeys("biberon");

        searchBox.sendKeys(Keys.ENTER);

        new WebDriverWait(webDriver, Duration.ofSeconds(6)).until(
                webDriver1 -> webDriver1.findElement(By.className("has-searchbox-results")).isDisplayed()
        );

        System.out.println("LOG 1 :: " + webDriver.getCurrentUrl());

        Assertions.assertTrue(webDriver.findElement(By.className("has-searchbox-results")).isDisplayed());

    }

    @Test
    @Order(2)
    public void clickOnFirstProduct() {

        new WebDriverWait(webDriver, Duration.ofSeconds(6)).until(
                webDriver1 -> !webDriver1.findElements(By.className("product-item-anchor")).isEmpty()
        );

        WebElement firstProduct = webDriver.findElements(By.className("product-item-anchor")).get(1);

        firstProduct.click();

        Assertions.assertTrue(firstProduct.isDisplayed());
    }

    @Test
    @Order(3)
    public void addToChart() {

        webDriver.findElement(By.id("addToCartBtn")).click();

        new WebDriverWait(webDriver, Duration.ofSeconds(3)).
                until(webDriver1 -> !webDriver1.findElements(By.className("modal-dialog")).isEmpty());

        Assertions.assertFalse(webDriver.findElements(By.className("modal-dialog")).isEmpty());
    }

    @Test
    @Order(4)
    public void validateChart() {

      webDriver.findElement(By.id("btnShowCart")).click();

        new WebDriverWait(webDriver, Duration.ofSeconds(3)).until(
                webDriver1 -> webDriver1.findElement(By.id("btnGoToShippingAddress")).isDisplayed()
        );

        Assertions.assertTrue(webDriver.findElements(By.className("basket-product-item")).size() > 0);
    }
}
