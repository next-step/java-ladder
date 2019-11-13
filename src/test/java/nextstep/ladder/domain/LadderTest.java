package nextstep.ladder.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private Ladder ladder;
    private List<Point> pointList;

    @BeforeEach
    void setUp() {
        List<Line> lineList = new ArrayList<>();
        pointList = Lists.newArrayList(new Point(Direction.LEFT), new Point(Direction.RIGHT), new Point(Direction.LEFT));
        lineList.add(new Line(pointList));
        ladder = new Ladder(lineList, 3);
    }

    @Test
    @DisplayName("ladder index 와 height를 전달해 Direction을 얻어 오는지 확인 한다.")
    void ladderDirection() {
        assertThat(ladder.ladderDirection(0, 1)).isEqualTo(Direction.RIGHT);
    }
}
