package nextstep.fp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LambdaTest {
    private List<Integer> numbers;

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
        int sum2 = Lambda.sumByCondition(numbers, n -> true);
        assertThat(sum).isEqualTo(21);
        assertThat(sum2).isEqualTo(sum);
    }

    @Test
    public void sumAllEven() throws Exception {
        int sum = Lambda.sumAllEven(numbers);
        int sum2 = Lambda.sumByCondition(numbers, n -> n % 2 == 0);
        assertThat(sum).isEqualTo(12);
        assertThat(sum2).isEqualTo(sum);
    }

    @Test
    public void sumAllOverThree() throws Exception {
        int sum = Lambda.sumAllOverThree(numbers);
        int sum2 = Lambda.sumByCondition(numbers, n -> n > 3);
        assertThat(sum).isEqualTo(15);
        assertThat(sum2).isEqualTo(sum);
    }
}