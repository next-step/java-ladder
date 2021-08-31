package nextstep.ladder;

import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class PointTest {
    @Test
    @DisplayName("사다리 첫 번째 Line 의 다음 값이 true 이면 가로 라인이 겹치지 않게 두번째 Line의 다음 값은 false이다.   ")
    void init() {
        Point first = Point.init(true);
        assertThat(first.insert()).isEqualTo(Point.of());
    }

    @Test
    void insert() {
        Point first = Point.init(false);
        assertThat(first.insert()).isEqualTo(Point.of(false));
    }

    @Test
    void insert2() {
        Point first = Point.init(false);
        assertThat(first.insert().currentPoint()).isEqualTo(Point.of(true).currentPoint());
    }
}
