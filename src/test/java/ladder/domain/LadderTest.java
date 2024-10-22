package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

    @Test
    void 라인_생성_성공_테스트() {
        Ladder ladder = new Ladder(4, 5, () -> true);
        assertThat(ladder.getLines()).contains(new Line(true, false, true, false));
    }

    @Test
    void 라인_생성_실패_테스트() {
        assertThatThrownBy(() -> new Ladder(4, 1, () -> true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("높이는 2이상이어야 합니다.");

    }
}