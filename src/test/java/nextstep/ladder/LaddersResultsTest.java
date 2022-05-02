package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LaddersResultsTest {

    @Test
    void create() {
        String[] stringResults = {"꽝", "5000", "꽝", "3000"};
        LaddersResults laddersResults = LaddersResults.makeLaddersResultsByUserInput(stringResults);
        assertThat(laddersResults).isEqualTo(LaddersResults.makeLaddersResultsByUserInput(stringResults));
    }
}