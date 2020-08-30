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

    @Test
    @DisplayName("For문 이용한 전체 출력 ")
    public void printAllOld() throws Exception {
        Lambda.printAllOld(numbers);
    }

    @Test
    @DisplayName("Lambda를 이용한 전체 출력 ")
    public void printAllLambda() throws Exception {
        Lambda.printAllLambda(numbers);
    }

    @Test
    @DisplayName("Thread 이용한 출력")
    public void runThread() throws Exception {
        Lambda.runThread();
    }

    @Test
    @DisplayName("전체 총 합을 구하는 테스트")
    public void sumAll() throws Exception {
        int sum = Lambda.sumAll(numbers);
        assertThat(sum).isEqualTo(21);
    }

    @Test
    @DisplayName("짝수 총 합을 구하는 테스트")
    public void sumAllEven() throws Exception {
        int sum = Lambda.sumAllEven(numbers);
        assertThat(sum).isEqualTo(12);
    }

    @Test
    @DisplayName("3이상 숫자 총 합을 구하는 테스트")
    public void sumAllOverThree() throws Exception {
        int sum = Lambda.sumAllOverThree(numbers);
        assertThat(sum).isEqualTo(15);
    }
}
