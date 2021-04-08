package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import nextstep.ladder.exception.LadderException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderHeightTest {

    @DisplayName("사다리 높이가 최솟값을 만족하지 못할 경우")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2})
    void ladderHeight_of(int ladderHeight) {
        assertThatThrownBy(() -> {
            LadderHeight.of(ladderHeight);
        }).isInstanceOf(LadderException.class)
            .hasMessage("사다리의 최소 높이는 1입니다.");
    }
}
