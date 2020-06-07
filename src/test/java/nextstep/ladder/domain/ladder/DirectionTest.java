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

    @Test
    @DisplayName("next 메소드 실행 테스트")
    void next() {
        Direction direction = Direction.RIGHT;
        Direction nextDirection = direction.next(() -> true);
        assertThat(nextDirection).isEqualTo(Direction.LEFT);
        assertThat(nextDirection.next(() -> true)).isNotEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("generate 메소드 실행 테스트")
    void generate() {
        Direction direction = Direction.generate(0, Direction.LEFT, () -> true);
        assertThat(direction).isEqualTo(Direction.RIGHT);
    }
}
