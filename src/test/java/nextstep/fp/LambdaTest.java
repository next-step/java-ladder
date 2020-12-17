package nextstep.fp;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LambdaTest {
    private List<Integer> numbers;

    @BeforeEach
    public void setup() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void printAllOld() {
        Lambda.printAllOld(numbers);
    }

    @Test
    public void printAllLambda() {
        Lambda.printAllLambda(numbers);
    }

    @Test
    public void runThread() {
        Lambda.runThread();
    }

    @Test
    public void sumAll() {
        int sum = Lambda.sumAll(numbers, number -> true);
        assertThat(sum).isEqualTo(21);
    }

    @Test
    public void sumAllEven() {
        int sum = Lambda.sumAllEven(numbers);
        assertThat(sum).isEqualTo(12);
    }

    @Test
    public void sumAllOverThree() {
        int sum = Lambda.sumAllOverThree(numbers);
        assertThat(sum).isEqualTo(15);
    }
}
