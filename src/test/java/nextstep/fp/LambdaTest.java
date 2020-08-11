package nextstep.fp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("전체를 출력한다 (기존)")
    @Test
    public void printAllOld() {
        Lambda.printAllOld(numbers);
    }

    @DisplayName("전체를 출력한다 (람다를 이용하여 개선)")
    @Test
    public void printAllLambda() {
        Lambda.printAllLambda(numbers);
    }

    @DisplayName("Thread 를 이용해 콘솔 출력")
    @Test
    public void runThread() {
        Lambda.runThread();
    }

    @DisplayName("전체 총 합이 올바른지 확인")
    @Test
    public void sumAll() {
        // given
        int expected = 21;

        // when
        int sum = Lambda.sumAll(numbers);

        // then
        assertThat(sum).isEqualTo(expected);
    }

    @DisplayName("전체 총 합이 올바른지 확인 (reduce 활용)")
    @Test
    public void sumAllUsingReduce() {
        // given
        int expected = 21;

        // when
        int sum = Lambda.sumAllUsingReduce(numbers);

        // then
        assertThat(sum).isEqualTo(expected);
    }

    @DisplayName("짝수 총 합이 올바른지 확인")
    @Test
    public void sumAllEven() {
        // given
        int expected = 12;

        // when
        int sum = Lambda.sumAllEven(numbers);

        // then
        assertThat(sum).isEqualTo(expected);
    }

    @DisplayName("3이상 되는 숫자들의 총 합이 올바른지 확인")
    @Test
    public void sumAllOverThree() {
        // given
        int expected = 15;

        // when
        int sum = Lambda.sumAllOverThree(numbers);

        // then
        assertThat(sum).isEqualTo(expected);
    }
}
