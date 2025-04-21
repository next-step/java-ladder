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

    @Test
    void 라인_이동_테스트() {
        LineDrawStrategy alwaysTrue = prev -> true;
        Line line = Line.generate(2, alwaysTrue);

        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(2);
    }
}