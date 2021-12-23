package nextstep.ladder.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {

    @ParameterizedTest
    @ValueSource(strings = {"꽝", "2000", "3000"})
    void createTest(String value) {
        // when
        LadderResult ladderResult = new LadderResult(value);
        // then
        assertThat(ladderResult).isNotNull();
    }
}
