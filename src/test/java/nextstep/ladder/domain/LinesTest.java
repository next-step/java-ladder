package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LinesTest {
    private Lines lines;

    @BeforeEach
    void setUp() {
        List<Line> exampleLines = Arrays.asList(
                new Line(Arrays.asList(new Point(0, Direction.RIGHT), new Point(0, Direction.RIGHT), new Point(0, Direction.RIGHT))),
                new Line(Arrays.asList(new Point(1, Direction.LEFT), new Point(1, Direction.LEFT), new Point(1, Direction.LEFT))),
                new Line(Arrays.asList(new Point(2, Direction.BOTTOM), new Point(1, Direction.BOTTOM), new Point(1, Direction.BOTTOM)))
        );
        lines = new Lines(exampleLines);
    }

    @Test
    @DisplayName("index와 height를 넘겼을때 해당 위치의 Direction을 리턴 하는지 확인")
    void getDirection() {
        assertThat(lines.getDirection(0, 0)).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("index와 height를 넘겼을때 해당 위치의 Point를 리턴 하는지 확인")
    void getPoint() {
        assertThat(lines.getPoint(0, 0)).isEqualTo(new Point(0, Direction.RIGHT));
    }

    @Test
    @DisplayName("이전 Line 기준으로 알맞는 Point가 생성되는지 확인")
    void createPoint() {
        assertThat(lines.createPoint(0, 0)).isIn(new Point(0, Direction.RIGHT), new Point(0, Direction.BOTTOM));
        assertThat(lines.createPoint(lines.getLastIndex(), 2)).isEqualTo(new Point(lines.getLastIndex(), Direction.BOTTOM));
        assertThat(lines.createPoint(1, 0)).isEqualTo(new Point(1, Direction.LEFT));
    }
}
