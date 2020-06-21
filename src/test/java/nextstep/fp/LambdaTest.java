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
        assertThat(Lambda.sumAll(numbers, number -> true)).isEqualTo(21);
    }

    @Test
    public void sumAllEven() throws Exception {
        assertThat(Lambda.sumAllEven(numbers)).isEqualTo(12);
    }

    @Test
    public void sumAllOverThree() throws Exception {
        assertThat(Lambda.sumAllOverThree(numbers)).isEqualTo(15);
    }
}
