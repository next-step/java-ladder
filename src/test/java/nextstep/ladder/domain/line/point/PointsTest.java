package nextstep.ladder.domain.line.point;

import nextstep.ladder.domain.line.SpecificLineGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PointsTest {

    @Test
    void of() {
        Points points = Points.of(1, new SpecificLineGenerator());

        Assertions.assertThat(points).isNotNull();
        Assertions.assertThat(points.getPoints().get(0).canMoveRight()).isTrue();
    }

    @Test
    void getPoints() {
        Points points = Points.of(1, new SpecificLineGenerator());

        List<Point> selectedPoints = points.getPoints();

        Assertions.assertThat(selectedPoints).isNotNull();
    }
}