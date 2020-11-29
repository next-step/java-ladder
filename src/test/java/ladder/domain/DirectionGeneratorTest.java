package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class DirectionGeneratorTest {
    private final DirectionGenerator directionGenerator = new DirectionGenerator() {
        @Override
        public Direction generateFirst() {
            return null;
        }

        @Override
        public Direction generateNext(Direction beforeDirection) {
            return null;
        }
    };

    @DisplayName("이전 방향이 오른쪽이 아닌 경우")
    @Test
    void generateLast_when_before_direction_is_not_right() {
        // given
        final Direction direction = Direction.valueOf(false, false);

        // when
        final Direction result = directionGenerator.generateLast(direction);

        // then
        assertThat(result).isEqualTo(Direction.valueOf(false, false));
    }

    @DisplayName("이전 방향이 오른쪽인 경우")
    @Test
    void generateLast_when_before_direction_is_right() {
        // given
        final Direction direction = Direction.valueOf(false, true);

        // when
        final Direction result = directionGenerator.generateLast(direction);

        // then
        assertThat(result).isEqualTo(Direction.valueOf(true, false));
    }
}