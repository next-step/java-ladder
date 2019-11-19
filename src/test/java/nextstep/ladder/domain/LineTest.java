package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    private Line line;
    private List<Point> list = Arrays.asList(new Point(0, Direction.BOTTOM), new Point(0, Direction.RIGHT), new Point(0, Direction.RIGHT));

    @BeforeEach
    void setUp() {
        line = new Line(list);
    }

    @Test
    @DisplayName("line의 height 리턴값 확인")
    void height() {
        assertThat(line.height()).isEqualTo(list.size());
    }

    @Test
    @DisplayName("height에 맞는 Direction 리턴 하는지 확인")
    void direction() {
        assertThat(line.getDirectionByHeight(1)).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("height에 맞는 Point 리턴 하는지 확인")
    void point() {
        assertThat(line.getPointByHeight(1)).isEqualTo(new Point(0, Direction.RIGHT));
    }
}
