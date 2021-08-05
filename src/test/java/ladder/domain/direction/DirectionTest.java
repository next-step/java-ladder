package ladder.domain.direction;

import ladder.domain.direction.Direction;
import ladder.domain.direction.DirectionValue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {
    @Test
    @DisplayName("emptyTest")
    public void emptyTest() {
        Direction direction = Direction.of(DirectionValue.EMPTY);
        assertThat(direction.isEmpty())
                .isTrue();
    }

    @Test
    @DisplayName("leftTest")
    public void leftTest() {
        Direction direction = Direction.of(DirectionValue.LEFT);
        assertThat(direction.isLeft())
                .isTrue();
    }

    @Test
    @DisplayName("rightTest")
    public void rightTest() {
        Direction direction = Direction.of(DirectionValue.RIGHT);
        assertThat(direction.isRight())
                .isTrue();
    }
}
