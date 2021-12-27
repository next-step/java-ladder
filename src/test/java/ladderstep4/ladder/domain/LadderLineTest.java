package ladderstep4.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LadderLineTest {
    @Test
    void LadderLine생성() {
        assertDoesNotThrow(() -> new LadderLine(2));
    }

    @Test
    void move테스트() {
        Point point = Point.first(true);
        List<Point> points = new ArrayList<>();
        points.add(point);
        points.add(point.last());

        LadderLine ladderLine = new LadderLine(points);
        assertThat(ladderLine.move(0)).isEqualTo(new Position(1));
        assertThat(ladderLine.move(1)).isEqualTo(new Position(0));
    }
}
