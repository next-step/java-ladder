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

    static Stream<Arguments> source() {
        return Stream.of(
                Arguments.arguments(
                        (NumbersPredicate) (num) -> num > 3
                        , 15
                ),

                Arguments.arguments(
                        (NumbersPredicate) (num) -> num % 2 == 0
                        , 12
                ),

                Arguments.arguments(
                        (NumbersPredicate) (num) -> true
                        , 21
                )
        );
    }
    @ParameterizedTest
    @MethodSource("source")
    void numberPredicate(NumbersPredicate predicate, int expected) {
        int sum = Lambda.sumNumbersPredicate(numbers, predicate);
        assertThat(sum).isEqualTo(expected);
    }
}
