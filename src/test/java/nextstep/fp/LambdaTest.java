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

    @DisplayName("주어진 리스트를 전부 출력할 수 있는지 테스트(오래된 버전)")
    @Test
    public void printAllOld() throws Exception {
        Lambda.printAllOld(numbers);
    }

    @DisplayName("주어진 리스트를 전부 출력할 수 있는지 테스트(람다 버전)")
    @Test
    public void printAllLambda() throws Exception {
        Lambda.printAllLambda(numbers);
    }

    // 이 부분도 테스트를 진행해야 하는건가요?
    @DisplayName("Lambda 인스턴스가 쓰레드가 실행 가능한지 테스트")
    @Test
    public void runThread() throws Exception {
        Lambda.runThread();
    }

    @DisplayName("리스트의 존재하는 모든 값들을 더한 누적값 테스트")
    @Test
    public void sumAll() throws Exception {
        int sum = Lambda.sumAll(numbers);
        assertThat(sum).isEqualTo(21);
    }

    @DisplayName("리스트의 존재하는 짝수 값들을 더한 누적값 테스트")
    @Test
    public void sumAllEven() throws Exception {
        int sum = Lambda.sumAllEven(numbers);
        assertThat(sum).isEqualTo(12);
    }

    @DisplayName("리스트의 존재하는 3초과의 값들을 더한 누적값 테스트")
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
