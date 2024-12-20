package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderIsWork {
    private WebDriver driver;
    //Локатор "Заказ оформлен"
    private By orderIsProcessed = By.xpath("//div[text()='Заказ оформлен']");

    public OrderIsWork(WebDriver driver) {

        this.driver = driver;
    }

    //метод возвращает истину, если поле Заказ оформлен отображено
    public boolean orderIsProcessedTextIsDisplayed() {

        return driver.findElement(orderIsProcessed).isDisplayed();
    }
}
