package nextstep.ladder.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderLineTest {
    private final int FIRST_POSITION = 0;
    private final int LADDER_LINE_SIZE = 3;

    private LadderLine ladderLine;

    @BeforeEach
    void setUp() {
        List<Point> lines = new ArrayList<>();

        Point point = Point.first(true);
        lines.add(point);
        lines.add(point = point.next(false));
        lines.add(point = point.next(true));
        lines.add(point.last());

        ladderLine = new LadderLine(lines);
    }

    @DisplayName("사람 수 만큼의 LadderLine 생성")
    @Test
    void lineCreateTest() {
        assertThat(ladderLine.getPoints().size()).isEqualTo(4);
    }

    @DisplayName("왼쪽 끝에서 move하면 오른쪽으로 이동")
    @Test
    void moveFromLeftEndTest() {
        assertThat(ladderLine.move(FIRST_POSITION)).isEqualTo(FIRST_POSITION + 1);
    }

    @DisplayName("오른쪽 끝에서 move하면 왼쪽으로 이동")
    @Test
    void moveFromRightEndTest() {
        assertThat(ladderLine.move(LADDER_LINE_SIZE)).isEqualTo(LADDER_LINE_SIZE - 1);
    }
}
