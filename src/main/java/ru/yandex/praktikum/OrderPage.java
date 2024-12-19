package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


//класс страницы ввода данных для осуществления заказа
public class OrderPage {

    private WebDriver driver;
    //локатор поля для вводи "Имя"
    private By orderName = By.xpath(".//input[@placeholder = '* Имя']");
    //локатор поля для вводи "Фамилия"
    private By orderSurname = By.xpath(".//input[@placeholder = '* Фамилия']");
    //локатор поля для вводи "Адрес"
    private By OrderAdress = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    //локатор поля для вводи "Станция метро"
    private By orderSubway = By.xpath(".//input[@placeholder = '* Станция метро']");
    //локатор селектора для выбора станции метро
    private By orderSubwaySelector = By.xpath(".//*[@class = 'select-search__select']");
    //локатор поля для вводи "Телефон"
    private By orderPhone = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    //локатор кнопки "Далее"
    private By buttonNext = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее')]");


    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод для ввода "Имя"
    public void enterOrderName(String name) {
        driver.findElement(orderName).sendKeys(name);
    }

    //метод для ввода "Фамилия"
    public void enterOrderSurname(String surname) {
        driver.findElement(orderSurname).sendKeys(surname);
    }

    //метод для ввода "Адрес"
    public void enterOrderAddress(String address) {
        driver.findElement(OrderAdress).sendKeys(address);
    }

    //метод для вызова списка "Станция метро"
    public void clickOrderSubway() {
        driver.findElement(orderSubway).click();
        driver.findElement(orderSubwaySelector).isDisplayed();
        driver.findElement(orderSubway).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
    }

    //метод для ввода "Телефон"
    public void enterOrderPhone(String phone) {
        driver.findElement(orderPhone).sendKeys(phone);
    }

    //метод для клика "Далее"
    public void clickButtonNext() {
        driver.findElement(buttonNext).click();
    }

    //Общий метод для ввода "Имя", "Фамилия", "Адрес", "Телефон", а так же выбора "Станция метро" и клика "Далее"
    public OrderPage enterAllOrderData (String name, String surname, String address, String phone){
        enterOrderName(name);
        enterOrderSurname(surname);
        enterOrderAddress(address);
        clickOrderSubway();
        enterOrderPhone(phone);
        clickButtonNext();
        return this;
    }

}