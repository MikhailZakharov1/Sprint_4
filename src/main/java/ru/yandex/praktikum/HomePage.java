package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


//Класс главной страницы сайта Самокат
public class HomePage {
    private WebDriver driver;
    //локатор верхней кнопки для заказа "Заказать"
    private By higherOrderButton = By.xpath(".//button[(@class ='Button_Button__ra12g' and text()='Заказать')]");
    //локатор нижней кнопки для заказа "Заказать"
    private By lowerOrderButton = By.xpath(".//div[@class ='Home_FinishButton__1_cWm']//button");
    //локаторы для кнопок вопросов из раздела "Вопросы о важном"
    private By buttonImportantQuestLi_0 = By.id("accordion__heading-0");
    private By buttonImportantQuestLi_1 = By.id("accordion__heading-1");
    private By buttonImportantQuestLi_2 = By.id("accordion__heading-2");
    private By buttonImportantQuestLi_3 = By.id("accordion__heading-3");
    private By buttonImportantQuestLi_4 = By.id("accordion__heading-4");
    private By buttonImportantQuestLi_5 = By.id("accordion__heading-5");
    private By buttonImportantQuestLi_6 = By.id("accordion__heading-6");
    private By buttonImportantQuestLi_7 = By.id("accordion__heading-7");
    //массив из локаторов для кнопок вопросов из раздела "Вопросы о важном"
    private By[] buttonsImpotantQuestionsArray = {buttonImportantQuestLi_0, buttonImportantQuestLi_1, buttonImportantQuestLi_2, buttonImportantQuestLi_3, buttonImportantQuestLi_4, buttonImportantQuestLi_5, buttonImportantQuestLi_6, buttonImportantQuestLi_7};
    //локаторы для текстов ответов из раздела "Вопросы о важном"
    private By answerImportantQuestLi_0 = By.xpath(".//div[@id='accordion__panel-0']/p");
    private By answerImportantQuestLi_1 = By.xpath(".//div[@id='accordion__panel-1']/p");
    private By answerImportantQuestLi_2 = By.xpath(".//div[@id='accordion__panel-2']/p");
    private By answerImportantQuestLi_3 = By.xpath(".//div[@id='accordion__panel-3']/p");
    private By answerImportantQuestLi_4 = By.xpath(".//div[@id='accordion__panel-4']/p");
    private By answerImportantQuestLi_5 = By.xpath(".//div[@id='accordion__panel-5']/p");
    private By answerImportantQuestLi_6 = By.xpath(".//div[@id='accordion__panel-6']/p");
    private By answerImportantQuestLi_7 = By.xpath(".//div[@id='accordion__panel-7']/p");
    //массив из локаторов для текстов ответов из раздела "Вопросы о важном"
    private By[] AnswearsImportQuestArray = {answerImportantQuestLi_0, answerImportantQuestLi_1, answerImportantQuestLi_2, answerImportantQuestLi_3, answerImportantQuestLi_4, answerImportantQuestLi_5, answerImportantQuestLi_6, answerImportantQuestLi_7};
    //массив с ожидаемыми ответами к вопросам из раздела "Вопросы о важном"
    private String[] expectedAnswersImportantQuestions = {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    //открыть главную страницу ЯндексСамокат
    public void openScooterPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    //скролл страницы и клик по кнопке в разделе "Вопросы о важном", с добавлением ожидания для появления элемента
    public void scrollClickButtonImportantQuest(int listIndex) {
        By locator = buttonsImpotantQuestionsArray[listIndex];
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    //клик по верхней кнопке "Заказать" на главной странице
    public void higherOrderButtonClick() {

        driver.findElement(higherOrderButton).click();

    }

    //клик по нижней кнопке Заказать
    public HomePage lowerOrderButtonClick() {
        WebElement element = driver.findElement(lowerOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(lowerOrderButton).click();
        return this;
    }

    //выбор кнопки "Заказать" на странице
    public HomePage chooseOrderButtonAndClick(String buttonLocation) {
        if (buttonLocation.equals("up")) {
            higherOrderButtonClick();
            return this;
        } else if (buttonLocation.equals("down")) {
            lowerOrderButtonClick();
            return this;
        }
        return this;
    }

    //метод для получения текста из текстовых ответов разделе "Вопросы о важном"
    public String getAnswersImportantQuestions(int listIndex) {
        By locator = AnswearsImportQuestArray[listIndex];
        return driver.findElement(locator).getText();
    }

    //метод для сравнения текстовых ответов с ожидаемыми ответами (добавлено ожидание, что бы проверить все варианты)
    public boolean contentIsDisplayed(int listIndex) {
        By locator = AnswearsImportQuestArray[listIndex];
        String expectedAnswersText = expectedAnswersImportantQuestions[listIndex];
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).isDisplayed() && getAnswersImportantQuestions(listIndex).equals(expectedAnswersText);
    }


}
