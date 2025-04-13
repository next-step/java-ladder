package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @Test
    void 라인_생성_테스트() {
        LineDrawStrategy alwaysTrue = prev -> true;
        Line line = Line.generate(3, alwaysTrue);
        assertThat(line.getPoints()).containsAll(List.of(new Point(true), new Point(true), new Point(true)));
    }
}