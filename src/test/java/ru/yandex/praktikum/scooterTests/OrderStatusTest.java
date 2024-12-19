package ru.yandex.praktikum.scooterTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.*;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderStatusTest extends Connection{

    private final String buttonLocation;
    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final int days ;
    private final String newColor;
    private final String newDate;
    private final String newComment;

    //конструктор тест-класса
    public OrderStatusTest(String buttonLocation, String name, String surname, String address, String phone, String newDate, int days, String newColor, String newComment) {
        this.buttonLocation = buttonLocation;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.newDate = newDate;
        this.days = days;
        this.newColor = newColor;
        this.newComment = newComment;
    }

    //данные для теста
    @Parameterized.Parameters
    public static Object[][] getOrderData(){
        return new Object[][]{
                {"up", "Михаил", "Захаров", "Саратовская", "89378433434", "01.01.2024", 1, "black", "Комментарий у заказа на серый черный"},
                {"down", "Кирил", "Жульенов", "Самарская", "89786566566", "06.06.2024", 5, "grey", "Комментарий у заказа на серый самокат"},
        };
    }

    @Test
    public void enterAllOrderDataTest (){
        //создать объект главной страницы
        HomePage objHomePage = new HomePage(driver);
        //обращение к сайту "Яндекс.Самокат"
        objHomePage.openScooterPage();
        //выбор кнопки для клика "Заказать"
        objHomePage.chooseOrderButtonAndClick(buttonLocation);

        //создание объекта страницы ввода данных для заказа самоката
        new OrderPage(driver) //вызов метода для ввода данных на странице Для кого самокат
                .enterAllOrderData(name, surname, address, phone);
        //создаю объект страницы Про аренду
        new RentOrderPage(driver)
                //вызов метода для ввода данных на странице Про аренду
                .enterAllDataRentOrder(newDate, days, newColor, newComment);
        //создаю объект страницы "Хотите оформить заказ?"
        new WishOrder(driver)
                //нажимаю кнопку Да в окне "Хотите оформить заказ?"
                .clickOkButton();
        //создаю объект страницы Заказ оформлен
        OrderIsWork objOrderIsProcessed = new OrderIsWork(driver);
        //проверка, что поле "Заказ оформлен". В приложении есть баг, который не даёт оформить заказ. Он воспроизводится только в Chrome
        assertTrue(objOrderIsProcessed.orderIsProcessedTextIsDisplayed());
    }

}






