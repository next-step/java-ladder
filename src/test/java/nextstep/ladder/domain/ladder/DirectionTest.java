package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DirectionTest {

    @Test
    @DisplayName("방향 생성 테스트")
    void create() {
        assertThatCode(() -> Direction.of(Direction.RIGHT)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("잘못된 방향 값 생성 예외 테스트")
    void InvalidArgumentException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Direction.of(3));
    }

    @Test
    @DisplayName("같은 방향 생성 시 equal 테스트")
    void equal() {
        Direction direction = Direction.of(Direction.LEFT);
        assertThat(direction).isEqualTo(Direction.of(Direction.LEFT));
    }
}
