package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ResultsTest {

    @Test
    void results() {
        Results results = new Results("3000", "꽝", "4000");

        assertThat(results.results()).containsExactly(new Result("3000"), new Result("꽝"), new Result("4000"));
    }
}
