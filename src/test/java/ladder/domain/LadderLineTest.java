package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LadderLineTest {

    private Line ladderLine;

    @BeforeEach
    public void setUp() {
        ladderLine = Line.generatePoints(4, () -> true);
    }

    @DisplayName("사다리 라인 생성 테스트")
    @Test
    public void create_Line() {
        List<Point> points = ladderLine.getUnmodifiableListPoints();

        assertAll(
                () -> assertThat(points.get(0).canMovePrevious()).isFalse(),
                () -> assertThat(points.get(0).canMoveNext()).isTrue(),
                () -> assertThat(points.get(1).canMovePrevious()).isTrue(),
                () -> assertThat(points.get(1).canMoveNext()).isFalse(),
                () -> assertThat(points.get(2).canMovePrevious()).isFalse(),
                () -> assertThat(points.get(2).canMoveNext()).isTrue(),
                () -> assertThat(points.get(3).canMovePrevious()).isTrue(),
                () -> assertThat(points.get(3).canMoveNext()).isFalse()
        );
    }
}