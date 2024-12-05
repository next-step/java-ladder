package nextstep.ladder.domain.line.point;

import nextstep.ladder.domain.line.SpecificLineGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class PointsTest {

    @Test
    void create_성공() {
        Points points = new Points(2, new SpecificLineGenerator());

        Assertions.assertThat(points).isNotNull();

        Assertions.assertThat(points.getPoints().get(0).canMoveLeft()).isFalse();
        Assertions.assertThat(points.getPoints().get(0).canMoveRight()).isTrue();

        Assertions.assertThat(points.getPoints().get(1).canMoveLeft()).isTrue();
        Assertions.assertThat(points.getPoints().get(1).canMoveRight()).isFalse();
    }

    @Test
    @DisplayName("포인트 수는 2개 이상이어야 한다 (=게임 참가자 수는 2명 이상이어야 한다)")
    void create_실패() {
        Assertions.assertThatThrownBy(() -> {
            Points points = new Points(1, new SpecificLineGenerator());
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getPoints() {
        Points points = new Points(2, new SpecificLineGenerator());

        List<Point> selectedPoints = points.getPoints();

        Assertions.assertThat(selectedPoints).isNotNull();
    }
}