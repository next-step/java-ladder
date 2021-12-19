package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PointTest {

    @Test
    @DisplayName("다음 다리 생성 테스트")
    void next() {
        Point point = new Point(new Index(), false);
        Point next = point.next(prev -> true);

        assertThat(next).isEqualTo(new Point(new Index(1), true));
    }

    @Test
    @DisplayName("인접한 다리가 있을시 IllegalArgumentException 발생")
    void validationNextPoint() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Point point = new Point(new Index(), true);
            point.next(prev -> true);
        });
    }
}