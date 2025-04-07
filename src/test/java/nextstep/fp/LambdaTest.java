package nextstep.fp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LambdaTest {
    private final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    @Test
    void 전체_합_계산() {
        assertEquals(21, Lambda.sumAll(numbers));
    }

    @Test
    void 짝수_합_계산() {
        assertEquals(12, Lambda.sumAllEven(numbers));
    }

    @Test
    void 세_초과_숫자_합_계산() {
        assertEquals(15, Lambda.sumAllOverThree(numbers));
    }
}
