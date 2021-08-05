package ladder.domain.point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderPointTest {
    @DisplayName("Point의 next를 호출할때마다 index가 올라간 Point를 반환해야 한다.")
    @Test
    void checkIndexTest() {
        LadderPoint point = LadderPoint.first();
        for (int index = 1; index < 100; index++) {
            point = point.next();
            assertThat(point.checkIndex(index))
                    .isTrue();
        }
    }
}