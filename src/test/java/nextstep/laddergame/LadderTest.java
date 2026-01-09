package nextstep.laddergame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.List;
import nextstep.laddergame.domain.Ladder;
import nextstep.laddergame.domain.Line;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    void 사다리_높이만큼_Line_을_생성한다() {
        Ladder ladder = new Ladder(3, 5);
        assertThat(ladder.lines().size()).isEqualTo(3);
    }

    @Test
    void lines와_golas의_수가_불일치하면_예외전파() {
        assertThatThrownBy(() -> {
            new Ladder(5, 3, "꽝");
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessage("사다리와 결과값이 다르다");
    }

    @Test
    void 특정참가자가_lines를_따라가서_0번_line이_마지막_golas_가_어딘지_나타낸다() {
        Ladder ladder = new Ladder(
            List.of(
                new Line(() -> List.of(true, false, false)),
                new Line(() -> List.of(false, true, false)),
                new Line(() -> List.of(true, false, false))
            ),
            "꽝", "당첨", "아슬");

        assertThat(ladder.traverse(0)).isEqualTo("아슬");
        assertThat(ladder.traverse(1)).isEqualTo("당첨");
        assertThat(ladder.traverse(2)).isEqualTo("꽝");
    }

}