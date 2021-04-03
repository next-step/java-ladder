package nextstep.ladder.domain;

import nextstep.ladder.generator.LineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("Line 생성 테스트")
    @Test
    void create_라인_생성테스트() {
        // given
        Line line = Line.valueOf(2);
        // when
        Line expected = Line.valueOf(2);
        // then
        assertThat(line).isEqualTo(expected);
    }

    @DisplayName("Line 전략별 생성 테스트")
    @Test
    void create_랜덤_전략_테스트() {
        // given
        LineGenerator lineGenerator = countOfPerson -> Arrays.asList(Point.init(), Point.of(true));
        // when
        Line line = Line.valueOf(2, lineGenerator);
        List<Point> points = line.points();
        // then
        assertThat(points.get(0).isExist()).isFalse();
        assertThat(points.get(1).isExist()).isTrue();
    }
}
