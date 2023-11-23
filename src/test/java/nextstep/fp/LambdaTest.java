package nextstep.fp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class LambdaTest {
    private List<Integer> numbers;
    private final static int MIN_NUMBER = 4;
    private final static Conditional conditional = (number) -> number >= MIN_NUMBER;

    @BeforeEach
    public void setup() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void printAllOld() throws Exception {
        Lambda.printAllOld(numbers);
    }

    @Test
    public void printAllLambda() throws Exception {
        Lambda.printAllLambda(numbers);
    }

    @Test
    public void runThread() throws Exception {
        Lambda.runThread();
    }

    @Test
    public void sumAll() throws Exception {
        int sum = Lambda.sumAll(numbers);
        assertThat(sum).isEqualTo(21);
    }

    @Test
    public void sumAllWithConditional() throws Exception {
        int sum = Lambda.sumAll(numbers, number -> true);
        assertThat(sum).isEqualTo(21);
    }

    @Test
    public void sumAllEven() throws Exception {
        int sum = Lambda.sumAllEven(numbers);
        assertThat(sum).isEqualTo(12);
    }

    @Test
    public void sumAllEvenWithConditional() throws Exception {
        int sum = Lambda.sumAllEven(numbers, number -> number % 2 == 0);
        assertThat(sum).isEqualTo(12);
    }

    @Test
    public void sumAllOverThree() throws Exception {
        int sum = Lambda.sumAllOverThree(numbers);
        assertThat(sum).isEqualTo(15);
    }

    @Test
    public void sumAllOverThreeWithConditional() throws Exception {
        int sum = Lambda.sumAllOverThree(numbers, number -> number > 3);
        assertThat(sum).isEqualTo(15);
    }
}
