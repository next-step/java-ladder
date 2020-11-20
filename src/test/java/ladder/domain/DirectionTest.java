package ladder.domain;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @Test
    @Description("Direction 의 getMove 값 확인")
    void getMove() {
        Assertions.assertAll(
                () -> assertThat(Direction.LEFT.getMove())
                        .isEqualTo(-1),
                () -> assertThat(Direction.DOWN.getMove())
                        .isEqualTo(0),
                () -> assertThat(Direction.RIGHT.getMove())
                        .isEqualTo(1)
        );
    }
}
