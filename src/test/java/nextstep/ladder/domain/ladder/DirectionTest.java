package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DirectionTest {

    @Test
    @DisplayName("방향 생성 테스트")
    void create() {
        assertThatCode(() -> Direction.of(-1)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("잘못된 방향 값 생성 null 테스트")
    void InvalidArgumentException() {
        assertThat(Direction.of(3)).isNull();
    }

    @Test
    @DisplayName("같은 방향 생성 시 equal 테스트")
    void equal() {
        Direction direction = Direction.of(-1);
        assertThat(direction).isEqualTo(Direction.LEFT);
    }
}
