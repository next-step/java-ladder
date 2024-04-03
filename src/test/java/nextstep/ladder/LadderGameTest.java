package nextstep.ladder;

import nextstep.ladder.domain.LadderGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderGameTest {

    @DisplayName("사다리 높이가 0이거나 음수를 입력했을 때, IllegalArgumentException을 반환한다")
    @Test
    void zeroOrNegative() {
        assertThatThrownBy(() -> new LadderGame(0, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 1 이상이어야 합니다.");
    }

    @DisplayName("Ladder 객체를 초기화했을 때, 입력한 사다리 높이에 따라 Line 객체가 생성된다")
    @Test
    void ladder() {
        assertThat(new LadderGame(5, 3).getLines().size()).isEqualTo(5);
    }

}
