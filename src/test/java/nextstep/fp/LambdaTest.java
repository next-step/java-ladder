package nextstep.fp;

import org.junit.jupiter.api.BeforeEach;
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

    //짝수만 홀수만 3 이상만
    @ParameterizedTest
    @MethodSource
    public void sumAll(Conditional conditional, int expected) {
        int sum = Lambda.sumAll(numbers, conditional);
        assertThat(sum).isEqualTo(expected);
    }

    static Stream<Arguments> sumAll() {
        return Stream.of(
                Arguments.of(
                        (Conditional) number -> number % 2 == 0, 12
                ),
                Arguments.of(
                        (Conditional) number -> number > 3, 15
                )
        );
    }
}
