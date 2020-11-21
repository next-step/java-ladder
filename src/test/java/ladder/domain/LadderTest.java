package ladder.domain;


import ladder.exception.BadPositionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderTest {
    private final int height = 5;
    private final int sizeOfPersons = 3;
    private final Ladder ladder = new Ladder(height, () -> new Line(sizeOfPersons, () -> false));

    @Test
    @DisplayName("Ladder 에 그려진 선 모양대로 position 이 move 해야한다.")
    void move() {
        assertAll(
                () -> assertThat(ladder.move(0))
                        .isEqualTo(1),
                () -> assertThat(ladder.move(1))
                        .isEqualTo(0),
                () -> assertThat(ladder.move(2))
                        .isEqualTo(2)
        );
    }

    @Test
    @DisplayName("sizeOfPersons 보다 더 큰 position 을 move 하려 하면, BadPositionException 이 발생한다.")
    void move_BadPosition() {
        assertThatExceptionOfType(BadPositionException.class)
                .isThrownBy(() -> ladder.move(sizeOfPersons));
    }
}
