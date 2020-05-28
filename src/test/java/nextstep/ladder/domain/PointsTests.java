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

    @DisplayName("이전 값이 false인 객체에 add 시 true값이 추가된 컬렉션으로 변화")
    @Test
    void addToFalseTest() {
        Points points = Points.create();
        points.add();
        points.add();
        assertThat(points.get(0)).isFalse();
        assertThat(points.get(1)).isTrue();
        assertThat(points.get(2)).isFalse();
    }
}
