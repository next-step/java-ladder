package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    private static final int VALID_MIM_COUNT_OF_PERSON = 2;

    private static final int INVALID_MIN_COUNT_OF_PERSON = 1;

    private static final int VALID_MAX_COUNT_OF_HEIGHT = 0;

    private static final int INVALID_MAX_COUNT_OF_HEIGHT = -1;

    @Test
    void 사다리는_최소_2명_이상_참가자가_있어야_한다() {
        assertThatThrownBy(() -> new Ladder(INVALID_MIN_COUNT_OF_PERSON, VALID_MAX_COUNT_OF_HEIGHT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여자는 최소 2명 이상이어야 합니다.");
    }

    @Test
    void 사다리는_최대_높이는_최소_0이상의_높이를_가져야_한다() {
        assertThatThrownBy(() -> new Ladder(VALID_MIM_COUNT_OF_PERSON, INVALID_MAX_COUNT_OF_HEIGHT))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최대 높이는 최소 0이상이어야 합니다.");
    }
}
