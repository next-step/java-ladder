package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static nextstep.ladder.domain.Direction.*;
import static org.assertj.core.api.Assertions.*;

public class PointsTest {

    @DisplayName("특정 위치 값을 인자로 받아 해당 위치 값을 다음 위치 값으로 옮겨 반환한다.")
    @Test
    void move() {
        // given
        Points points = new Points(List.of(
            new Point(0, RIGHT),
            new Point(1, LEFT),
            new Point(2, CENTER)
        ));

        int currentPoint = 1;

        // when & then
        assertThat(points.move(currentPoint)).isEqualTo(0);
    }
}
