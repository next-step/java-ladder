package nextstep.ladder;

import nextstep.ladder.domain.LaddersResults;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.*;

class LaddersResultsTest {

    @Test
    void create() {
        LaddersResults laddersResults = LaddersResults.create(asList("꽝", "5000", "꽝", "3000"));
        assertThat(laddersResults).isEqualTo(LaddersResults.create(asList("꽝", "5000", "꽝", "3000")));
    }
}