package nextstep.ladder.domain;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LineTest {
    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(booleans = {true, false})
    void 초기값_무조건_false(boolean param) {
        Line line = Line.of(2, () -> param);
        Line targetLine = Line.createWithVariables(false, param);
        assertThat(line).isEqualTo(targetLine);
    }

    @Test
    void true뒤_무조건_false() {
        Line line = Line.of(3, () -> true);
        Line targetLine = Line.createWithVariables(false, true, false);
        assertThat(line).isEqualTo(targetLine);
    }

    @Test
    void 모두_false_확인() {
        Line line = Line.of(3, () -> false);
        Line targetLine = Line.createWithVariables(false, false, false);
        assertThat(line).isEqualTo(targetLine);
    }
}
