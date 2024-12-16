package ru.yandex.praktikum;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//класс страницы Про аренду
public class RentOrderPage {
    private WebDriver driver;
    //локатор для "Когда привезти самокат"
    private By orderDataWhenDelivery = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //локатор для "Срок аренды"
    private By rentalPeriod = By.className("Dropdown-placeholder");
    //локатор для "Срок аренды - сутки"
    private By period_1day = By.xpath(".//*[@class='Dropdown-option'][1]");
    //локатор для "Срок аренды - 2 суток"
    private By period_2days = By.xpath(".//*[@class='Dropdown-option'][2]");
    //локатор для "Срок аренды - 3 суток"
    private By period_3days = By.xpath(".//*[@class='Dropdown-option'][3]");
    //локатор для "Срок аренды - 4 суток"
    private By period_4days = By.xpath(".//*[@class='Dropdown-option'][4]");
    //локатор для "Срок аренды - 5 суток"
    private By period_5days = By.xpath(".//*[@class='Dropdown-option'][5]");
    //локатор для "Срок аренды - 6 суток"
    private By period_6days = By.xpath(".//*[@class='Dropdown-option'][6]");
    //локатор для "Э"Срок аренды - 7 суток"
    private By period_7days = By.xpath(".//*[@class='Dropdown-option'][7]");
    //Цвет самоката "Черный жемчуг"
    private By blackPearl = By.xpath(".//input[@id='black']");
    //Цвет самоката "Серая безысходность"
    private By grayHopelessness = By.xpath(".//input[@id='grey']");
    //поле "Комментарий для курьера"
    private By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //кнопка "Заказать"
    private By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    public RentOrderPage(WebDriver driver) {

        this.driver = driver;
    }

    //метод для выбора даты в поле Когда привезти самокат
    public void enterDate(String newDate) {
        driver.findElement(orderDataWhenDelivery).sendKeys(newDate);
        driver.findElement(orderDataWhenDelivery).sendKeys(Keys.ENTER);
    }

    //метод для выбора количества дней аренды
    public void choosePeriod(int days) {
        driver.findElement(rentalPeriod).click();
        if (days == 1) {
            driver.findElement(period_1day).click();
        } else if (days == 2) {
            driver.findElement(period_2days).click();
        } else if (days == 3) {
            driver.findElement(period_3days).click();
        } else if (days == 4) {
            driver.findElement(period_4days).click();
        } else if (days == 5) {
            driver.findElement(period_5days).click();
        } else if (days == 6) {
            driver.findElement(period_6days).click();
        } else if (days == 7) {
            driver.findElement(period_7days).click();
        }
    }

    //выбор цвета самоката "Черный жемчуг"
    public void clickBlackPearl() {

        driver.findElement(blackPearl).click();
    }

    //выбор цвета самоката "Серая безысходность"
    public void clickGrayHopelessness() {

        driver.findElement(grayHopelessness).click();
    }

    //метод выбора цвета
    public void chooseColor(String newColor) {
        if (newColor.equals("black")) {
            clickBlackPearl();
        } else if (newColor.equals("grey")) {
            clickGrayHopelessness();
        }
    }

    //метод ввода комментария для курьера
    public RentOrderPage enterComment(String newComment) {

        driver.findElement(comment).sendKeys(newComment);
        return this;
    }

    //метод нажатия кнопки "Заказать"
    public RentOrderPage clickOrderButton() {

        driver.findElement(orderButton).click();
        return this;
    }

    //общий метод ввода "Даты", "Комментария", а так же выбора периода, выбора цвета и клик кнопки "Заказать" на странице Про аренду
    public RentOrderPage enterAllDataRentOrder(String newDate, int days, String newColor, String newComment) {
        enterDate(newDate);
        choosePeriod(days);
        chooseColor(newColor);
        enterComment(newComment);
        new WebDriverWait(driver, 3);
        clickOrderButton();
        return this;
    }


}

