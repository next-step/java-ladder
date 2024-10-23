package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void 사다리_생성_성공_테스트() {
        Ladder ladder = Ladder.of(4, 5, () -> true);
        assertThat(ladder.getLines()).contains(new Line(false, true, false, true));
    }

    @Test
    void 사다리_생성_실패_테스트() {
        assertThatThrownBy(() -> Ladder.of(4, 1, () -> true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("높이는 2 이상이어야 합니다.");

    }

}