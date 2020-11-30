package nextstep.fp.lamda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LambdaTest {
    private List<Integer> numbers;

    @BeforeEach
    public void setup() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void sumAll() {
        int sum = Lambda.printSum(numbers, number -> true);
        assertEquals(sum, 21);
    }

    @Test
    public void sumAllEven() {
        int sum = Lambda.printSum(numbers, number -> (number % 2 == 0));
        assertEquals(sum, 12);
    }

    @Test
    public void sumAllOverThree() {
        int sum = Lambda.printSum(numbers, number -> (number > 3));
        assertEquals(sum, 15);
    }
}
