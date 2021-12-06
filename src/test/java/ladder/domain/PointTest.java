package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PointTest {

    @Test
    @DisplayName("포인트 생성")
    void create() {
        Point point = new Point(new Position(3), true, false);
        assertThat(point).isEqualTo(new Point(new Position(3), true, false));
    }

}
