package DZ4;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;



import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class TriangleAreaTest {


    public static Logger logger = LoggerFactory.getLogger(TriangleAreaTest.class);
    TriangleArea testResult = new TriangleArea();

    @BeforeAll
    static void beforeAll() {
        //System.out.println("Общее предусловие");
        logger.info("Что-то");
        logger.info("Общее предусловие");
        logger.debug("debug level");
        logger.error("error");
    }

    @BeforeAll
    static void prepearTest() {
        System.out.println("Что-то готовим для матча");
    }

    @BeforeEach
    void tearUp() {
        System.out.println("Test начался");
    }


    @Test
    @DisplayName("Позитивная проверка")
    void testTriangleArea() {
        double result = testResult.triangleAreaNormData(6.3, 2.0, 7.0);
        Assertions.assertEquals(6.16, result);
    }

    @DisplayName("Позитивная проверка пакетным методом")
    @ParameterizedTest
    @CsvSource({"6.3,2.0,7.0,6.16", "9.4, 3.0, 10.4, 13.84", "14.3, 17.8, 9.3, 66.18"})
    void testTriangleAreaCSV(double a, double b, double c, double expectedResult) {
        Assertions.assertEquals(testResult.triangleAreaNormData(a, b, c), expectedResult);
    }

    @Test
    @DisplayName("Негативная проверка по стороне")
    void checkDataBooleanTest() {
        assertThat(testResult.checkDataBoolean(3.0, 19.2, 6.8)).isFalse();
    }

    @ParameterizedTest
    @DisplayName("Смешаные проверки пакетом")
    @CsvSource({"6.9, 19.9, 8.0, false", "8.8, 12.4, 6.1, true", "2.3, 8.0, 9.1, false"})
    void checkDataBooleanTestParam(double a, double b, double c, boolean result) {
        Assertions.assertEquals(testResult.checkDataBoolean(a, b, c), result);
    }


    @AfterEach
    void tearDown() {
        System.out.println("Станция пройдена");
    }

    @AfterAll
    static void cleanBaza() {
        System.out.println("Чистим базу после матча");
    }

    @Test
    @DisplayName("Проверка первого исключения")
    void checkNegativSideExceptionTest() {
// assertThatExceptionOfType(BoxIsEmptyException.class).isThrownBy(() -> box.deleteBall());
        assertThatExceptionOfType(NegativSideException.class).isThrownBy
                (() -> testResult.checkData(-3.0, 1.5, 2.0));
    }

    @Test
    @DisplayName("Проверка второго исключения")
    void checkShortSideExeptionTest() {
        assertThatExceptionOfType(ShortSideException.class)
                .isThrownBy(() -> testResult.checkData(6.0, 25.1, 15.4));
    }
}
