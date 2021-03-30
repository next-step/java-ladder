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

    @DisplayName(value = "forEach로 반복되는 코드 테스트")
    @Test
    public void printAllOld() {
        Lambda.printAllOld(numbers);
    }

    @DisplayName(value = "메서드 레퍼런스를 통한 반복 코드 테스트")
    @Test
    public void printAllLambda() {
        Lambda.printAllLambda(numbers);
    }

    @DisplayName(value = "Runnable도 FunctionalInterface이므로 람다를 통한 스레드 테스트가 가능")
    @Test
    public void runThread() {
        Lambda.runThread();
    }

    @DisplayName(value = "sumAll 전체 숫자를 합산하도록 람다식 작성 테스트")
    @Test
    public void sumAll() {
        int sum = Lambda.sumAll(numbers, (number) -> true);
        assertThat(sum).isEqualTo(21);
    }

    @DisplayName(value = "sumAllEven 짝수에 대한 filter를 람다로 작성하여 연산 테스트")
    @Test
    public void sumAllEven() {
        int sum = Lambda.sumAllEven(numbers, (number) -> number % 2 == 0);
        assertThat(sum).isEqualTo(12);
    }

    @Test
    public void sumAllOverThree() throws Exception {
        int sum = Lambda.sumAllOverThree(numbers);
        assertThat(sum).isEqualTo(15);
    }
}
