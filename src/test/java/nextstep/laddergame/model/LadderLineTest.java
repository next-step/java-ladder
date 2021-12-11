package nextstep.laddergame.model;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderLineTest {

    @DisplayName("points가 주어졌을 때 정상적으로 움직이는지 검증")
    @Test
    void moveTest() {
        List<Point> points = Arrays.asList(new Point(0, Direction.first(true)));
        LadderLine ladderLine = new LadderLine(points);
        assertThat(ladderLine.move(0)).isEqualTo(1);
    }
}
