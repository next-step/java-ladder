package nextstep.ladder;

import nextstep.ladder.domain.Direction;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    @DisplayName("사다리는 여러개의 선으로 이루어진다")
    void 사다리_생성() {
        Line line = new Line(new Point(Direction.RIGHT));
        Ladder ladder = new Ladder(line);
        assertThat(ladder.ladder()).isEqualTo(Arrays.asList(line));
    }
}
