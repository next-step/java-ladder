package nextstep.fp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("람다 실습 - Lambda 클래스 테스트")
public class LambdaTest {
    private List<Integer> numbers;

    @BeforeEach
    public void setup() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("람다 없던 시절 출력")
    public void printAllOld() throws Exception {
        Lambda.printAllOld(numbers);
    }

    @Test
    @DisplayName("람다를 이용한 출력")
    public void printAllLambda() throws Exception {
        Lambda.printAllLambda(numbers);
    }

    @Test
    @DisplayName("쓰레드 실행")
    public void runThread() throws Exception {
        Lambda.runThread();
    }

    @Test
    @DisplayName("리스트의 모든 숫자를 더한다.")
    public void sumAll() throws Exception {
        int sum = Lambda.sumAll(numbers);
        assertThat(sum).isEqualTo(21);
    }

    @Test
    @DisplayName("리스트의 숫자 중 짝수만 더한다.")
    public void sumAllEven() throws Exception {
        int sum = Lambda.sumAllEven(numbers);
        assertThat(sum).isEqualTo(12);
    }

    @Test
    @DisplayName("리스트의 숫자 중 3보다 큰 수만 더한다.")
    public void sumAllOverThree() throws Exception {
        int sum = Lambda.sumAllOverThree(numbers);
        assertThat(sum).isEqualTo(15);
    }
}
