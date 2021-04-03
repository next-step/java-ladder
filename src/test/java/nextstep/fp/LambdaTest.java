package nextstep.fp;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LambdaTest {

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
        Lambda.runThread();
    }

    @Test
    void sumAll() {
        int sum = Lambda.sumAllMatchingCondition(numbers, x -> true);
        assertThat(sum).isEqualTo(21);
    }

    @Test
    void sumAllEven() {
        int sum = Lambda.sumAllMatchingCondition(numbers, x -> x % 2 == 0);
        assertThat(sum).isEqualTo(12);
    }

    @Test
    void sumAllOverThree() {
        int sum = Lambda.sumAllOverThree(numbers);
        assertThat(sum).isEqualTo(15);
    }
}
