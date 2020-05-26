package nextstep.fp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        int sum = Lambda.sumAll(numbers, number -> true);
        assertThat(sum).isEqualTo(21);
    }

    @Test
    public void sumAllEven() throws Exception {
        int sum = Lambda.sumAll(numbers, number -> number % 2 == 0);
        assertThat(sum).isEqualTo(12);
    }

    @Test
    public void sumAllOverThree() throws Exception {
        int sum = Lambda.sumAll(numbers, number -> number > 3);
        assertThat(sum).isEqualTo(15);
    }

    @DisplayName("조건에 맞는 숫자는 해당 숫자를 반환하고, 조건에 맞지 않는 숫자는 0을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"4:4", "2:0"}, delimiter = ':')
    public void conditionMatchNumber(int inputNumber, int result) {
        Integer resultNumber = Lambda.conditionMatchNumber(inputNumber, number -> number > 3);
        assertThat(resultNumber).isEqualTo(result);
    }
}
