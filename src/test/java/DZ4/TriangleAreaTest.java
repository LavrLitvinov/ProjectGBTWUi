package DZ4;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TriangleAreaTest {


    TriangleArea testResult = new TriangleArea();

    @BeforeAll
    static void prepearTest(){
        System.out.println("Что-то готовим для матча");
    }

    @BeforeEach
    void tearUp(){
        System.out.println("Test начался");
    }


    @Test
    void testTriangleArea(){
        double result = testResult.triangleAreaNormData(6.3,2.0,7.0);
        Assertions.assertEquals(6.16,result);
    }
    @DisplayName("Проверка пакетным методом")
    @ParameterizedTest
    @CsvSource({"6.3,2.0,7.0,6.16", "9.4, 3.0, 10.4, 13.84", "14.3, 17.8, 9.3, 66.18"})
    void testTriangleAreaCSV(double a, double b, double c, double expectedResult){
        Assertions.assertEquals(testResult.triangleAreaNormData(a,b,c), expectedResult);
    }
    @AfterEach
    void tearDown(){
        System.out.println("Станция пройдена");
    }
    @AfterAll
    static void cleanBaza() {
        System.out.println("Чистим базу после матча");
    }

}
