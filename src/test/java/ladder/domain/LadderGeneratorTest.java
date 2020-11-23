package ladder.domain;

import ladder.exception.BadPositionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderGeneratorTest {

    private final int height = 3;
    private final int sizeOfPersons = 5;
    private final DirectionStrategy directionStrategy = new DirectionStrategy() {
        @Override
        Direction get() {
            return get(false);
        }
    };
    private final LineGenerator lineGenerator = new LineGenerator(sizeOfPersons, directionStrategy);
    private final LadderGenerator ladderGenerator = new LadderGenerator(height, lineGenerator);
    private final Ladder ladder = ladderGenerator.generate();

    @Test
    @DisplayName("sizeOfPersons 보다 더 큰 position 을 move 하려 하면, BadPositionException 이 발생한다.")
    void move_BadPosition() {
        assertAll(
                () -> assertThatExceptionOfType(BadPositionException.class)
                        .isThrownBy(() -> ladder.move(sizeOfPersons)),
                () -> assertThatExceptionOfType(BadPositionException.class)
                        .isThrownBy(() -> ladder.move(sizeOfPersons + 7))
        );
    }

    @Test
    @DisplayName("ladder 에 그려진 선 모양대로 position 이 move 해야한다.")
    void move() {
        assertAll(
                () -> assertThat(ladder.move(0))
                        .isEqualTo(1),
                () -> assertThat(ladder.move(1))
                        .isEqualTo(0),
                () -> assertThat(ladder.move(2))
                        .isEqualTo(3),
                () -> assertThat(ladder.move(3))
                        .isEqualTo(2),
                () -> assertThat(ladder.move(4))
                        .isEqualTo(4)
        );
    }
}
