package ladder.domain.expert;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class DirectionTest {

    @Test
    @Description("Direction 의 getMove 값 확인")
    void getMove() {
        assertAll(
                () -> assertThat(Direction.LEFT.getMove())
                        .isEqualTo(-1),
                () -> assertThat(Direction.DOWN.getMove())
                        .isEqualTo(0),
                () -> assertThat(Direction.RIGHT.getMove())
                        .isEqualTo(1)
        );
    }
}
