package ladder;

import ladder.domain.Results;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultsTest {
    @Test
    void 결과_입력_생성() {
        String input = "꽝,5000,꽝,3000";

        Results results = new Results(input);
        assertThat(results.countOfResults()).isEqualTo(4);
    }

    @Test
    void 결과_입력_값검사() {
        String input = "꽝,5000,꽝,3000";

        Results results = new Results(input);
        assertThat(results.getResults().get(0).getResult()).isEqualTo("꽝");
    }
}
