package nextstep.version.refactor.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointsTest {

    @DisplayName("한 라인의 포인트들을 만들 수 있다.")
    @Test
    void createPoints() {
        Points points = new Points(new Boolean[]{true});
        boolean result = points.hasLine(0);
        assertTrue(result);
    }

    @DisplayName("크기가 1이하 인 경우 에러를 반환한다.")
    @Test
    void sizeError() {
        Assertions.assertThatThrownBy(() -> new Points(new Boolean[]{}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("특정 지점의 포인트를 이동할 수 있다.")
    @Test
    void movePoint() {
        Points points = new Points(new Boolean[]{true});
        Integer movePoint = points.move(0);
        Assertions.assertThat(movePoint).isEqualTo(1);
    }

    @DisplayName("첫 번째를 제외하고 왼쪽으로 이동할 수 있다.")
    @Test
    void leftMovePoint() {
        Points points = new Points(new Boolean[]{false,true,false});
        Integer movePoint = points.move(2);
        Assertions.assertThat(movePoint).isEqualTo(1);
    }
}
