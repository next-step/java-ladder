package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    public static final Line LINE_TEST1 = new Line(List.of(true, false, false, true));
    public static final Line LINE_TEST2 = new Line(List.of(true, false, true, false));

    @Test
    @DisplayName("Line 생성 테스트")
    void createLine() {
        Line line = new Line(5, () -> true);
        assertThat(line).isEqualTo(new Line(5, () -> true));
    }

    @Test
    @DisplayName("point 테스트")
    void getPoints() {
        List<Boolean> pointList = List.of(true, false, true, false);
        Line line = new Line(pointList);
        assertThat(line.getPoints()).containsAll(pointList);
    }
}