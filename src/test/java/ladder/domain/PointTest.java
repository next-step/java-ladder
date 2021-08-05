package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {
    @DisplayName("Point의 next를 호출할때마다 index가 올라간 Point를 반환해야 한다.")
    @Test
    void checkIndexTest() {
        assertThat(
                Point.first().next().checkIndex(1)
        ).isTrue();
    }
}