package nextstep.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class PointsTest {
    @Test
    @DisplayName("일단 간단테스트")
    void dummy() {
        Points points = new Points();
        assertThat(points).isNotNull();
    }
}
