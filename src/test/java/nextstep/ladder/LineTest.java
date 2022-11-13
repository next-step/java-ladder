package nextstep.ladder;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @Test
    void checkPointAndChangePosition() {
        Players players = new Players(new String[]{"A", "B", "C", "D"});
        Line line = new Line(List.of(new Point(true), new Point(false), new Point(false)));

        line.checkPointAndChangePosition(players);

        assertThat(players).isEqualTo(new Players(new String[]{"B", "A", "C", "D"}));
    }
}
