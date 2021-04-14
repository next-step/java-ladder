package nextstep.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class PointsTest {
    @Test
    @DisplayName("생성")
    void constructor() {
        Points points = new Points(1);
        assertThat(points).isNotNull();
    }

    @Test
    @DisplayName("입력테스트")
    void add() {
        Points points = new Points(3);
        points.markOne(0, false);
        points.markOne(1, true);
        points.markOne(2,false);
        assertThat(points.size()).isEqualTo(3);
    }
}
