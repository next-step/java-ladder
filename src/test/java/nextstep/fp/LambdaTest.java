package nextstep.fp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LambdaTest {
    private List<Integer> numbers;

    @BeforeEach
    void setup() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    void printAllOld() {
        Lambda.printAllOld(numbers);
    }

    @Test
    void printAllLambda() {
        Lambda.printAllLambda(numbers);
    }

    @Test
    void runThread() {
        Lambda.runInThread();
    }

    @Test
    void sumAll() {
        int sum = Lambda.sumAllNumbers(numbers);

        assertThat(sum).isEqualTo(21);
    }

    @Test
    void sumAllEven() {
        int sum = Lambda.sumAllEvenNumbers(numbers);

        assertThat(sum).isEqualTo(12);
    }

    @Test
    void sumAllOverThree() {
        int sum = Lambda.sumAllGreaterThanThree(numbers);

        assertThat(sum).isEqualTo(15);
    }
}
