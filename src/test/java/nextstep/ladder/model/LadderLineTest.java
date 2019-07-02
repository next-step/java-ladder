package nextstep.ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {
    private final int FIRST_POSITION = 0;

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
    void Line_만들기() {
        assertThat(ladderLine.getPoints().size()).isEqualTo(4);
    }

    @DisplayName("한 줄짜리 사다리 테스트")
    @Test
    void goDownTest() {
        assertThat(ladderLine.move(FIRST_POSITION)).isEqualTo(FIRST_POSITION + 1);
    }
}
