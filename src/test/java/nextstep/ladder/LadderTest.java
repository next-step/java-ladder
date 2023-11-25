package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @Test
    void 사다리는_최소_1명_이상_참가자가_있어야_한다() {
        assertThatThrownBy(() -> new Ladder(0, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참여자는_최소_1명_이상이어야_합니다.");
    }
}
