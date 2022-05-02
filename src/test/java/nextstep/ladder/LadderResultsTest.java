package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderResultsTest {

    @Test
    void create() {
        String[] stringResults = {"꽝", "5000", "꽝", "3000"};
        LadderResults ladderResults = new LadderResults(stringResults);
        assertThat(ladderResults).isEqualTo(new LadderResults(stringResults));
    }
}