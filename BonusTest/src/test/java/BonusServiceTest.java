import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {

        BonusService calculate = new BonusService();

        long amount = 100060;
        boolean registered = true;
        long expected = 30;
        long actual = calculate.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {

        BonusService calculate = new BonusService();

        long amount = 1_000_000_60;
        boolean registered = true;
        long expected = 500;
        long actual = calculate.calculate(amount, registered);

        assertEquals(expected, actual);
    }



    @Test
    void shouldCalculateForUnRegisteredAndOverLimit() {

        BonusService calculate = new BonusService();

        long amount = 1_000_000_60;
        boolean registered = false;
        long expected = 500;
        long actual = calculate.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnRegisteredAndUnderLimit() {

        BonusService calculate = new BonusService();

        long amount = 100060;
        boolean registered = false;
        long expected = 10;
        long actual = calculate.calculate(amount, registered);

        assertEquals(expected, actual);
    }


    @Test           //////// Данный тест создат специально, хотелось понять, возможно ли проверить условие, к прмиеру полученный бонус должен быть менее ожидаемого.
    void shouldCalculateForUnRegisteredAndExpectedMoreActual() {

        BonusService calculate = new BonusService();

        long amount = 100060;
        boolean registered = false;
        long expected = 30;
        long actual = calculate.calculate(amount, registered);

        assertTrue(expected > actual);
    }


}