package nextstep.step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ResultsTest {

    @Test
    @DisplayName("Result 별 index 부여")
    void initResults() {
        String rewards = "1000,2000,3000";
        Results results = Results.initResults(rewards);

        Result result1 = Result.of(0, "1000");
        Result result2 = Result.of(1, "2000");
        Result result3 = Result.of(2, "3000");
        Results manualResults = Results.from(Arrays.asList(result1, result2, result3));

        Assertions.assertThat(results).isEqualTo(manualResults);
    }

}