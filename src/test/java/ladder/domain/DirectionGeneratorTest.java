package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionGeneratorTest {

    @Test
    @DisplayName("RIGHT 이후에는 항상 LEFT 가 나오는지 테스트")
    void generateDirection() {
        DirectionGenerator generator = new DirectionGenerator();
        Assertions.assertAll(
                () -> assertThat(generator.generateDirection(true))
                        .isEqualTo(Direction.DOWN),
                () -> assertThat(generator.generateDirection(false))
                        .isEqualTo(Direction.RIGHT),
                () -> assertThat(generator.generateDirection(false))
                        .isEqualTo(Direction.LEFT),
                () -> assertThat(generator.generateDirection(false))
                        .isEqualTo(Direction.RIGHT),
                () -> assertThat(generator.generateDirection(true))
                        .isEqualTo(Direction.LEFT)
        );
    }
}
