package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class DirectionTest {
    @Test
    @DisplayName("of 메서드를 통해 좌 우 방향을 가진 Direction 을 생성한다.")
    void of() {
        assertThat(Direction.of(TRUE, FALSE).isLeft()).isTrue();
    }
}
