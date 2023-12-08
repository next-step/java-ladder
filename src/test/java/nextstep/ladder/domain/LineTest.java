package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LineTest {
    List<Point> points;

    @BeforeEach
    void setUp() {
        points = new ArrayList<>();
        points.add(new Point(true));
        points.add(new Point(true));
    }

    @DisplayName("사다리 라인이 연속으로 들어온다.")
    @Test
    void 사다리_다리_연속_에러() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Line(points))
                .withMessage("두 사다리는 연속으로 등장할 수 없습니다.");
    }
}
