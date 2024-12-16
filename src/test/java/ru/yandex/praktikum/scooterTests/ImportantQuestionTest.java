package ru.yandex.praktikum.scooterTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.HomePage;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class ImportantQuestionTest extends ConnectionChrome {
    private final int listIndex;

    //конструктор тест-класса Вопросы о важном с 2 параметрами
    public ImportantQuestionTest(int listIndex) {
        this.listIndex = listIndex;
    }

    //набор тестовых данных
    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {0},
                {1},
                {2},
                {3},
                {4},
                {5},
                {6},
                {7},
        };
    }

    @Test
    public void IsVisibleTextWhenClickedButton() {
        //создается объект класса главной страницы
        HomePage objHomePage = new HomePage(driver);
        //открытие главной страницы
        objHomePage.openScooterPage();
        //клик по кнопке с вопросом в зависимости от индекса
        objHomePage.scrollClickButtonImportantQuest(listIndex);
        //сравниваю результаты
        assertTrue(objHomePage.contentIsDisplayed(listIndex));
    }


}
