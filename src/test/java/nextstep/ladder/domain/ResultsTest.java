package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {
    @Test
    @DisplayName("results 생성")
    void createResults() {
        Results results = Results.from("꽝,5000,3000");

        Results resultsExpected = new Results(Arrays.asList(new Result("꽝"), new Result("5000"), new Result("3000")));
        assertThat(results).isEqualTo(resultsExpected);
    }
}
