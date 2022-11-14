package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class LadderTest {

    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmpty(final List<LadderLine> ladderLines) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new Ladder(ladderLines));
    }

}