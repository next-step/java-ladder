package reladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    private Point point;

    @BeforeEach
    void setUp() {
        point = new Point(0, Direction.first(true));
    }

    @Test
    @DisplayName("같은 값일 때 객체주소 값 비교")
    void pointEqualsWhenSameValue() {
        // give
        Point newPoint = new Point(0, Direction.first(true));
        // when
        boolean isSame = point.equals(newPoint);
        // then
        assertThat(isSame).isTrue();
    }
}
