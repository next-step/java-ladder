package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    @DisplayName("Point 클래스 생성")
    void createPoint() {
        Point point = new Point(true);
        assertThat(point).isEqualTo(new Point(true));
    }
}
