package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {

    @Test
    void 사다리는_높이가_1_이상_이여야_한다() {
        assertThatThrownBy(() -> new Ladder(2, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리는 높이가 1 이상이여야 합니다");
    }
}