package nextstep.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ResultsTest {

    @Test
    @DisplayName("Result 별 index 부여")
    void initResults() {
        String rewards = "1000,2000,3000";
        Results results = Results.initResults(3, rewards);

        Result result1 = Result.of(0, "1000");
        Result result2 = Result.of(1, "2000");
        Result result3 = Result.of(2, "3000");
        Results manualResults = Results.from(Arrays.asList(result1, result2, result3));

        assertThat(results).isEqualTo(manualResults);
    }

    @Test
    @DisplayName("결과 개수가 참가자 수와 일치 하지 않을 경우 예외 처리")
    void resultNumberException() {
        String results = "1000,2000";

        assertThrows(IllegalArgumentException.class,
                () -> Results.initResults(1, results));
    }

}