package ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {

    @DisplayName("사다리의 point가 생성되면 true 아니면 false.")
    @Test
    void createPoint() {
        // when
        Point point = new Point(() -> true);
        boolean actuality = point.isValue();

        // then
        Assertions.assertThat(actuality).isTrue();
    }
}