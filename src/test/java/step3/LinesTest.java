package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Line;
import step2.domain.Lines;
import step2.domain.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    @Test
    @DisplayName("여러 라인을 만드는 테스트")
    void multiLineTest() {

        Lines lines = new Lines(3,3);
        assertThat(lines.lines().size()).isEqualTo(3);

    }

    @Test
    @DisplayName("사다리 게임 결과 테스트")
    void resultLadderGame() {
        Lines lines = new Lines(createLine());
        assertThat(lines.eachPositionResult(0)).isEqualTo(2);
        assertThat(lines.eachPositionResult(1)).isEqualTo(0);
        assertThat(lines.eachPositionResult(2)).isEqualTo(1);
    }

    public List<Line> createLine() {
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(Arrays.asList(Point.first(true), Point.first(true).next(false), Point.first(true).next(false).last())));
        lines.add(new Line(Arrays.asList(Point.first(false), Point.first(false).next(false), Point.first(true).next(false).last())));
        lines.add(new Line(Arrays.asList(Point.first(false), Point.first(false).next(true), Point.first(false).next(true).last())));
        return lines;
    }

}
