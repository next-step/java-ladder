package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RandomDirectionGeneratorTest {
    private final RandomDirectionGenerator randomDirectionGenerator = new RandomDirectionGenerator();

    @DisplayName("이전 방향이 'right'인 경우 방향은 'left'이어야 한다.")
    @Test
    void return_direction_should_left_when_before_direction_is_right() {
        // given
        final Direction beforeDirection = Direction.valueOf(false, true);

        // when
        final Direction result = randomDirectionGenerator.generateNext(beforeDirection);

        // then
        assertThat(result.hasLeft()).isTrue();
        assertThat(result.hasRight()).isFalse();
    }

    @DisplayName("첫 번째 방향을 만드는 경우 'left'는 나올 수 없음")
    @Test
    void create_first_direction_should_not_left() {
        // when
        final Direction direction = randomDirectionGenerator.generateFirst();

        // then
        assertThat(direction).isNotNull();
        assertThat(direction.hasLeft()).isFalse();
    }

    @DisplayName("마지막 방향을 만드는 경우 'right'는 나올 수 없음")
    @Test
    void create_last_direction_should_not_right() {
        // given
        final Direction direction = Direction.valueOf(false, true);

        // when
        final Direction result = randomDirectionGenerator.generateLast(direction);

        // then
        assertThat(result.hasLeft()).isTrue();
        assertThat(result.hasRight()).isFalse();
    }
}