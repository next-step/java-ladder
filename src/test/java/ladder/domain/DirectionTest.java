package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DirectionTest {
    @Test
    @DisplayName("direction의 이동 범위를 반환한다.")
    void direction_생성() {
        Direction direction = Direction.RIGHT;
        assertThat(direction.getX()).isEqualTo(1);
        assertThat(direction.getY()).isEqualTo(0);
    }
}
