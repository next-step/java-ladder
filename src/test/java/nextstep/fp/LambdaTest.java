package nextstep.fp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LambdaTest {
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

    @DisplayName("리스트의 모든 수의 합 구하기")
    @Test
    void sumAll() throws Exception {
        int sum = Lambda.sumAll(numbers, n -> true);
        assertThat(sum).isEqualTo(21);
    }

    @DisplayName("리스트의 모든 수 중에 짝수 합 구하기")
    @Test
    void sumAllEven() throws Exception {
        int sum = Lambda.sumAll(numbers, n -> n % 2 == 0);
        assertThat(sum).isEqualTo(12);
    }

    @DisplayName("리스트의 모든 수 중에 3을 넘어선 수 합 구하기")
    @Test
    void sumAllOverThree() throws Exception {
        int sum = Lambda.sumAll(numbers, n -> n > 3);
        assertThat(sum).isEqualTo(15);
    }
}
