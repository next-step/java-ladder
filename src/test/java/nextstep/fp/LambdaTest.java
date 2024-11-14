package nextstep.fp;

import org.junit.jupiter.api.BeforeEach;
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

/* 테스트 코드는 수정하지 않는다.
    @Test
    public void sumAllLamda() throws Exception {
        Conditional defaultConditional = ((number) -> true);
        int sum = Lambda.sumAllLamda(numbers, defaultConditional);
        assertThat(sum).isEqualTo(21);
    }

    @Test
    public void sumAllEvenLamda() throws Exception {
        Conditional evenConditional = ((number) -> number % 2 == 0);

        int sum = Lambda.sumAllLamda(numbers, evenConditional);

        assertThat(sum).isEqualTo(12);
    }

    @Test
    public void sumAllOverThreeLamda() throws Exception {
        Conditional overThreeConditional = (number -> number > 3);
        int sum = Lambda.sumAllLamda(numbers, overThreeConditional);
        assertThat(sum).isEqualTo(15);
    }*/
}
