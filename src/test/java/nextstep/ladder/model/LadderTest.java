package nextstep.ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private final int COUNT_OF_HEIGHT = 3;
    private final int COUNT_OF_PERSON = 4;
    private final int LENGTH_OF_POINT = 5;
    private final int LENGTH_OF_PIPELINE = 1;

    private Ladder ladder;

    @BeforeEach
    void setUp() {
        List<Point> lines_1 = new ArrayList<>();
        Point point_1 = Point.first(true);
        lines_1.add(point_1);
        lines_1.add(point_1 = point_1.next(false));
        lines_1.add(point_1 = point_1.next(true));
        lines_1.add(point_1.last());

        List<Point> lines_2 = new ArrayList<>();
        Point point_2 = Point.first(false);
        lines_2.add(point_2);
        lines_2.add(point_2 = point_2.next(true));
        lines_2.add(point_2 = point_2.next(false));
        lines_2.add(point_2.last());

        List<LadderLine> ladderLines = new ArrayList<>();
        ladderLines.add(new LadderLine(lines_1));
        ladderLines.add(new LadderLine(lines_2));
        ladderLines.add(new LadderLine(lines_1));

        ladder = new Ladder(ladderLines);
    }

    @DisplayName("세 줄짜리 사다리 테스트")
    @Test
    void moveToResultTest() {
        final int FIRST_POSITION = 0;
        assertThat(ladder.moveToResult(FIRST_POSITION)).isEqualTo(FIRST_POSITION + 3);
    }

    @DisplayName("실행결과 Line의 문자열 총 길이 체크")
    @Test
    void getFormattedLineTest() {
        assertThat(ladder.getFormattedLine().length()).isEqualTo((COUNT_OF_PERSON * (LENGTH_OF_POINT + LENGTH_OF_PIPELINE) + LENGTH_OF_PIPELINE) * COUNT_OF_HEIGHT);
    }
}
