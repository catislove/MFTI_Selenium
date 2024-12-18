import org.fpmi.User;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleJUnitTests {
    @Test
    void simpleJUnitTest() {
        int actualSum = 2 + 2;
        int expectedSum = 4;
        assertEquals(expectedSum, actualSum);
    }

    @Test
    void disabledTest() {
        int actualSum = 2 + 2;
        int expectedSum = 4;
        assertEquals(expectedSum, actualSum);
        System.out.println("Test");
    }

    @Test
    @DisplayName("Сложение двух чисел")
    void titleTest() {
        int actualSum = 2 + 2;
        int expectedSum = 4;
        assertEquals(expectedSum, actualSum);
    }

    @Test
    @Tag("smoke")
    void tagTest() {
        int actualSum = 2 + 2;
        int expectedSum = 4;
        assertEquals(expectedSum, actualSum, "Суммы должны быть разными");
    }


    @RepeatedTest(value = 3, name = "{displayName} - повторение {currentRepetition} из {totalRepetitions}")
    @DisplayName("Сложение двух чисел")
    void repeatedTest() {
        int actualSum = 2 + 2;
        int expectedSum = 4;
        assertEquals(expectedSum, actualSum);
    }

    @Test
    void assertTrueFalseTest() {
        int actualSum = 2 + 2;
        int expectedSum = 4;
        assertTrue(expectedSum == actualSum);
        assertFalse(expectedSum != actualSum);
    }

    @Test
    void exceptionTest() {
        String test = null;
        Exception thrown = assertThrows(NullPointerException.class, () -> test.length());

        Assertions.assertEquals("Cannot invoke \"String.length()\" because \"test\" is null", thrown.getMessage());
    }

    @Test
    void assertsAllTest() {
        User user = new User("John", "Doe", 30);
        assertAll(
                () -> assertEquals("John", user.getFirstName(), "Неправильное имя"),
                () -> assertEquals("Doe", user.getLastName(), "Неправильная фамилия"),
                () -> assertEquals(30, user.getAge(), "Неправильный возраст")
        );
    }

    @Test
    void AssertAllSeparate() {
        User user = new User("John", "Doe", 30);
        assertEquals("John", user.getFirstName(), "Неправильное имя");
        assertEquals("Doe", user.getLastName(), "Неправильная фамилия");
        assertEquals(30, user.getAge(),  "Неправильный возраст");
    }

    @Test
    public void first() throws Exception{
        System.out.println("FirstParallelUnitTest first() start => " + Thread.currentThread().getName());
        Thread.sleep(500);
        System.out.println("FirstParallelUnitTest first() end => " + Thread.currentThread().getName());
    }

    @Test
    public void second() throws Exception{
        System.out.println("FirstParallelUnitTest second() start => " + Thread.currentThread().getName());
        Thread.sleep(500);
        System.out.println("FirstParallelUnitTest second() end => " + Thread.currentThread().getName());
    }


}
