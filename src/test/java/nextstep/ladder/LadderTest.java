package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    private List<Line> lines;

    @BeforeEach
    public void setUp() {
        lines = List.of(new Line(true, false, true), new Line(false, true, false), new Line(true, false, false),
                        new Line(false, true, false), new Line(true, false, true)
                );
    }

    @Test
    void move_각_포인트의_사다리이동_결과를_설정한다() {
        int countOfPoint = 4;
        Ladder ladder = new Ladder(countOfPoint, lines);

        ladder.move();

        assertThat(ladder).isEqualTo(new Ladder(countOfPoint, lines, List.of(0,3,2,1)));
    }
}
