package nextstep.fp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

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

    @ParameterizedTest
    @MethodSource("testFilterGenerator")
    public void sum(Condition condition, int expected) throws Exception {
        int sum = Lambda.sum(numbers, condition);
        assertThat(sum).isEqualTo(expected);
    }

    private static Stream<Arguments> testFilterGenerator() {
        return Stream.of(
                arguments((Condition) i -> true, 21),
                arguments((Condition) i -> (i % 2) == 0, 12),
                arguments((Condition) i -> i > 3, 15)
        );
    }
}
