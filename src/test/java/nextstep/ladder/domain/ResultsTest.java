package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author han
 */
class ResultsTest {

    static final String RESULTS = "꽝,5000,꽝,3000";

    @Test
    void createByString() {
        Results results = Results.createByString(RESULTS);
        assertThat(results.getResult().size()).isEqualTo(4);
    }
}