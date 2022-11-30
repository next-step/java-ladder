package nextstep.ladder;

import nextstep.ladder.domain.Direction;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    @DisplayName("사다리는 여러개의 선으로 이루어진다")
    void 사다리_생성() {
        Line line = new Line(new Point(Direction.RIGHT));
        Ladder ladder = new Ladder(line);
        assertThat(ladder.ladder()).isEqualTo(Arrays.asList(line));
    }

    @Test
    @DisplayName("사다리를 움직이면 각 지점의 최종 위치가 나온다")
    void 사다리_게임() {
        Line line1 = new Line(asList(new Point(Direction.RIGHT,0), new Point(Direction.LEFT,1), new Point(Direction.RIGHT,2),new Point(Direction.LEFT,3)));
        Line line2 = new Line(asList(new Point(Direction.RIGHT,0), new Point(Direction.LEFT,1), new Point(Direction.STRAIGHT,2),new Point(Direction.STRAIGHT,3)));
        Line line3 = new Line(asList(new Point(Direction.STRAIGHT,0), new Point(Direction.RIGHT,1), new Point(Direction.LEFT,2),new Point(Direction.STRAIGHT,3)));

        Ladder ladder = new Ladder(Arrays.asList(line1, line2, line3));

        HashMap<Integer,Integer> expected = new HashMap<>();
        expected.put(0,0);
        expected.put(1,2);
        expected.put(2,3);
        expected.put(3,1);

        ladder.move(4);
        assertThat(ladder.result()).isEqualTo(expected);
    }

}
