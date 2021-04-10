package nextstep.fp;

import nextstep.fp.strategy.Conditional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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

    @DisplayName("Conditional 을 기준으로 연산 진행 여부 테스트")
    @ParameterizedTest(name = "루프 : {index}, 예상 결과 값 : {1}")
    @MethodSource("provideConditional")
    void sumAllByConditional(Conditional conditional, int expected) {
        int actual = Lambda.sumAllByConditional(numbers, conditional);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideConditional() {
        return Stream.of(
                Arguments.of((Conditional) number -> true, 21),
                Arguments.of((Conditional) number -> number % 2 == 0, 12),
                Arguments.of((Conditional) number -> number > 3, 15)
        );
    }

}
