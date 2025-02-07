package infokes.pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static infokes.Drivers.getDriver;
import static infokes.utils.Utils.ELEMENTS;
import static infokes.utils.Utils.printError;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasePageObject {
    public By element(String elementLocator) {
        String elementValue = ELEMENTS.getProperty(elementLocator);
        if (elementValue == null) {
            printError("Couldn't find element : " + elementLocator + " ! Please check properties file!");
            throw new NoSuchElementException("Couldn't find element : " + elementLocator);
        } else {
            String[] locator = elementValue.split("_");
            String locatorType = locator[0];
            String locatorValue = elementValue.substring(elementValue.indexOf("_") + 1);
            return switch (locatorType) {
                case "id" -> By.id(locatorValue);
                case "name" -> By.name(locatorValue);
                case "xpath" -> By.xpath(locatorValue);
                case "containsText" -> By.xpath(String.format("//*[contains(@text, '%s')]", locatorValue));
                case "cssSelector" -> By.cssSelector(locatorValue);
                default -> throw new IllegalStateException("Unexpected locator type: " + locatorType);
            };
        }
    }

    public void typeOn(By by, String text) {
        WebElement element = getDriver().findElement(by);
        element.sendKeys(text);
    }

    public void typeOn(String element, String text) {
        typeOn(element(element), text);
    }

    public void clickOn(By by) {
        WebElement element = getDriver().findElement(by);
        element.click();
    }

    public void clickOn(String element) {
        clickOn(element(element));
    }

    public void assertIsDisplayed(By by) {
        WebElement element = getDriver().findElement(by);
        assertTrue(element.isDisplayed());
    }

    public void assertIsDisplayed(String element) {
        assertIsDisplayed(element(element));
    }

    public void isTextSame(By by, String textExpected) {
        WebElement element = getDriver().findElement(by);
        assertEquals(textExpected, element.getText());
    }

    public void isTextSame(String element, String textExpected) {
        isTextSame(element(element), textExpected);
    }

    public void waitABit(int seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(seconds).toMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
