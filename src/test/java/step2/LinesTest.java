package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Height;
import step2.domain.Line;
import step2.domain.Lines;
import step2.domain.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    @Test
    @DisplayName("라인들 생성")
    void createLines() {
        Lines lines = new Lines();
        assertThat(lines).isEqualTo(new Lines());
    }

    @Test
    @DisplayName("사다리 생성 결과 테스트")
    void createLadder() {
//        Lines lines = new Lines(createLineList());
        int height = 3;
        Lines lines = Lines.lines(new Height(height), 3);
        assertThat(lines.lines().size()).isEqualTo(height);
    }

    public List<Line> createLineList() {
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(Arrays.asList(new Point(true), new Point(false), new Point(true))));
        lines.add(new Line(Arrays.asList(new Point(true), new Point(false), new Point(true))));
        lines.add(new Line(Arrays.asList(new Point(true), new Point(false), new Point(true))));
        return lines;
    }
}
