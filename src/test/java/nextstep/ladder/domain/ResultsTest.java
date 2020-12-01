package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultsTest {
    @Test
    @DisplayName("results 생성")
    void createResults() {
        Results results = Results.from(3, "꽝,5000,3000");

        Results resultsExpected = new Results(Arrays.asList(new Result("꽝"), new Result("5000"), new Result("3000")));
        assertThat(results).isEqualTo(resultsExpected);
    }

    @Test
    @DisplayName("results 생성 시 사이즈 다르면 에러")
    void createResults_notMatchSize() {
        assertThatThrownBy(() -> {
            Results.from(4, "꽝,5000,3000");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("length and results size is different");
    }
}
