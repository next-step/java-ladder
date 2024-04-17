package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {
    @Test
    @DisplayName("결과 생성 테스트")
    public void initResultsTest() {
        Results results = new Results(Arrays.asList("a", "b", "c"));

        assertThat(results.getResultsCount()).isEqualTo(3);
        assertThat(results.getResult(0)).isEqualTo("a");
        assertThat(results.getResult(1)).isEqualTo("b");
        assertThat(results.getResult(2)).isEqualTo("c");
    }
}