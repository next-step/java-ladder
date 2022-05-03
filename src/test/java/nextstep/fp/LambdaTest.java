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
        int sum = Lambda.sumAll(numbers, (x) -> true);
        assertThat(sum).isEqualTo(21);
    }

    @Test
    public void sumAllEven() throws Exception {
        int sum = Lambda.sumAllEven(numbers, (x) -> x % 2 == 0);
        assertThat(sum).isEqualTo(12);
    }

    @Test
    public void sumAllOverThree() throws Exception {
        int sum = Lambda.sumAllOverThree(numbers, (x) -> x > 3);
        assertThat(sum).isEqualTo(15);
    }

    @Test
    public void sumAll2() throws Exception {
        int sum = Lambda.sumAll2(numbers, (x, y) -> x + y);
        assertThat(sum).isEqualTo(21);
    }

    @Test
    public void sumAllEven2() throws Exception {
        int sum = Lambda.sumAllEven2(numbers, (x, y) -> {
            if (y % 2 == 0)
                return x + y;
            return x;
        });
        assertThat(sum).isEqualTo(12);
    }

    @Test
    public void sumAllOverThree2() throws Exception {
        int sum = Lambda.sumAllOverThree2(numbers, (x, y) -> {
            if (y > 3)
                return x + y;
            return x;
        });
        assertThat(sum).isEqualTo(15);
    }

}
