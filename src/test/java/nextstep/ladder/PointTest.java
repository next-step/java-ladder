package nextstep.ladder;

import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.PointType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    void pointCreateTest() {
        Point emptyPoint = Point.createEmpty();
        assertThat(emptyPoint.toString()).isEqualTo(PointType.EMPTY.getText());

        Point verticalLinePoint = Point.createVerticalLine();
        assertThat(verticalLinePoint.toString()).isEqualTo(PointType.VERTICAL_LINE.getText());

        Point horizontalLinePoint = Point.createHorizontalLine();
        assertThat(horizontalLinePoint.toString()).isEqualTo(PointType.HORIZONTAL_LINE.getText());

        Point randomEmptyPoint = Point.createRandomlyHorizontalLine(() -> false);
        assertThat(randomEmptyPoint.toString()).isEqualTo(PointType.EMPTY.getText());

        Point randomHorizontalLinePoint = Point.createRandomlyHorizontalLine(() -> true);
        assertThat(randomHorizontalLinePoint.toString()).isEqualTo(PointType.HORIZONTAL_LINE.getText());
    }
}
