package ladder;

import ladder.domain.Results;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {
    @Test
    void 결과_이름_입력_나누기() {
        String input = "꽝,5000,꽝,3000";

        Results results = new Results(input);
        assertThat(results.countOfResults()).isEqualTo(4);
    }
}
