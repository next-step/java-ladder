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
    @DisplayName("generate 메소드 실행 테스트")
    void generate() {
        Direction direction = Direction.generate(() -> true);
        assertThat(direction).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("fist true 메소드 실행 테스트")
    void first() {
        Direction direction = Direction.first(() -> true);
        assertThat(direction).isEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("left일 때 next 메소드 directionPredicate true 실행 테스트")
    void next_with_random_true() {
        Direction direction = Direction.LEFT.next(()->true);
        assertThat(direction).isNotEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("left일 때  next 메소드 directionPredicate false 실행 테스트")
    void next_with_left_and_false() {
        Direction direction = Direction.LEFT.next(() -> false);
        assertThat(direction).isNotEqualTo(Direction.LEFT);
    }
    @Test
    @DisplayName("right 일 때 next 메소드 directionPredicate false 실행 테스트")
    void next_with_direction_right() {
        Direction direction = Direction.RIGHT.next(() -> true);
        assertThat(direction).isEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("현재 방향이 left일 때 last 메소드 실행 테스트")
    void last_with_direction_left() {
        Direction direction = Direction.LEFT.last();
        assertThat(direction).isEqualTo(Direction.DOWN);
    }

    @Test
    @DisplayName("현재 방향이 right 때 last 메소드 실행 테스트")
    void last_with_direction_right() {
        Direction direction = Direction.RIGHT.last();
        assertThat(direction).isEqualTo(Direction.LEFT);
    }
}
