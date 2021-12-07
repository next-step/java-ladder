package nextstep.ladder.model.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    @DisplayName("생성 테스트")
    void createTest() {
        Point point = new Point(true);

        assertThat(point.isTrue()).isEqualTo(true);
    }
}
