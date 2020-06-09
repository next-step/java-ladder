package nextstep.fp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

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
        assertThat(sum).isEqualTo(21);
    }

    @Test
    public void sumAllEven() throws Exception {
        int sum = Lambda.sumAllEven(numbers);
        assertThat(sum).isEqualTo(12);
    }

    @Test
    public void sumAllOverThree() throws Exception {
        int sum = Lambda.sumAllOverThree(numbers);
        assertThat(sum).isEqualTo(15);
    }

    @DisplayName("람다실습 2 - sumAll, sumAllEven, sumAllOverThree를 중복을 제거하여 구현한다")
    @Test
    void sumByCondition() {
        int sumAllResult = Lambda.sumByCondition(numbers, (number) -> true);
        int sumAllEven = Lambda.sumByCondition(numbers, (number) -> number % 2 == 0);
        int sumAllOverThree = Lambda.sumByCondition(numbers, (number) -> number > 3);

        assertAll(
                () -> assertThat(sumAllResult).isEqualTo(Lambda.sumAll(numbers)),
                () -> assertThat(sumAllEven).isEqualTo(Lambda.sumAllEven(numbers)),
                () -> assertThat(sumAllOverThree).isEqualTo(Lambda.sumAllOverThree(numbers))
        );
    }
}
