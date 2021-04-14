package nextstep.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class PointsTest {
    @Test
    @DisplayName("생성")
    void constructor() {
        Points points = new Points();
        assertThat(points).isNotNull();
    }

    @Test
    @DisplayName("입력테스트")
    void add() {
        Points points = new Points();
        points.add(false);
        points.add(true);
        points.add(false);
        assertThat(points.size()).isEqualTo(3);
    }
}
