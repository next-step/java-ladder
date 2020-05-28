package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointsTests {
    @DisplayName("객체 생성 시 컬렉션의 첫 상태가 false인 객체 생성")
    @Test
    void createTest() {
        Points points = Points.create();
        assertThat(points.get(0)).isFalse();
    }
}
