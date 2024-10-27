package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    void play_사다리를_탔을_때_도착지를_순서대로_출력한다() {
        Ladder ladder = new Ladder(4,
                List.of(new Line(true, false, true), new Line(false, true, false), new Line(true, false, false),
                        new Line(false, true, false), new Line(true, false, true)
                )
        );

        assertThat(ladder.play()).isEqualTo(List.of(0, 3, 2, 1));
    }
}
