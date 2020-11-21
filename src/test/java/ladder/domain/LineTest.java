package ladder.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("라인의 Direction 을 따라 position 이 움직여야 한다.")
    void move() {
        int sizeOfPersons = 5;
        Line line = new Line(sizeOfPersons, () -> false);
        Assertions.assertAll(
                () -> assertThat(line.move(0))
                        .isEqualTo(1),
                () -> assertThat(line.move(1))
                        .isEqualTo(0),
                () -> assertThat(line.move(2))
                        .isEqualTo(3),
                () -> assertThat(line.move(3))
                        .isEqualTo(2),
                () -> assertThat(line.move(4))
                        .isEqualTo(4)
        );
    }
}
