package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 사다리_게임_결과_테스트() {
        Ladder ladder = new Ladder(new PositiveNumber(5), List.of(new Line(false, true, false, true), new Line(false, false, true, false), new Line(false, true, false, false), new Line(false, false, true, false), new Line(false, true, false, true)));

        assertThat(ladder.getPersonLadderResult(1)).isEqualTo(3);
        assertThat(ladder.getPersonLadderResult(3)).isEqualTo(1);
        assertThat(ladder.getPersonLadderResult(0)).isEqualTo(0);
    }

}