package ladder.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ResultsTest {

    @Test
    void results() {
        Results results = new Results("3000", "꽝", "4000");

        assertThat(results.results()).containsExactly(new LadderTextInput("3000"), new LadderTextInput("꽝"), new LadderTextInput("4000"));
    }

    @DisplayName("인덱스로 결과를 가져온다.")
    @Test
    void result() {
        Results results = new Results("3000", "꽝", "4000");

        assertThat(results.result(1)).isEqualTo(new LadderTextInput("꽝"));
    }
}
