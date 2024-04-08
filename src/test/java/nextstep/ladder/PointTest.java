package nextstep.ladder;

import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {
    @Test
    @DisplayName("라인 그리기 생성 테스트")
    void pointSuccessTest() {
        Point point = new Point(() -> true);
        assertThat(point.isActive()).isTrue();
    }

    @Test
    @DisplayName("라인 그리기 실패 테스트")
    void pointFailTest() {
        Point point = new Point(() -> false);
        assertThat(point.isActive()).isFalse();
    }

}
