package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @DisplayName("포인트는 방향 데이터를 저장한다.")
    @Test
    void direction() {
        Point point = Point.TRUE;
        assertThat(point.hasRightDirection()).isTrue();
    }
}
