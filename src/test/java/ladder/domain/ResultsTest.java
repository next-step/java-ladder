package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {
    public static final Results RESULTS = new Results(Arrays.asList(ResultTest.RESULT_1, ResultTest.RESULT_2, ResultTest.RESULT_3, ResultTest.RESULT_4));

    @Test
    @DisplayName("결과 생성 테스트")
    public void initResultsTest() {
        Results results = new Results(Arrays.asList(ResultTest.RESULT_1, ResultTest.RESULT_2, ResultTest.RESULT_3));

        assertThat(results.getResultsCount()).isEqualTo(3);
        assertThat(results.getResult(0)).isEqualTo("1등");
        assertThat(results.getResult(1)).isEqualTo("2등");
        assertThat(results.getResult(2)).isEqualTo("3등");
    }
}