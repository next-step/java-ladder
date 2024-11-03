package nextstep.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointsTest {

    @Test
    @DisplayName("생성된 Point 사이즈 확인")
    void size() {
        Points points = new Points(6);
        assertThat(points.getSize()).isEqualTo(6);
    }
}
