package nextstep.ladder.domain.direction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class DirectionDeterminerTest {

    private DirectionDeterminer directionDeterminer;

    @BeforeEach
    void init() {
        directionDeterminer = new DirectionDeterminer(before -> before);
    }

    @Test
    void generateRightDown() {
        assertThat(directionDeterminer.next(true)).isEqualTo(Direction.RIGHT_DOWN);
    }

    @Test
    void generateLeftDown() {
        assertThat(directionDeterminer.next(true)).isEqualTo(Direction.RIGHT_DOWN);
        assertThat(directionDeterminer.next(false)).isEqualTo(Direction.LEFT_DOWN);
    }

    @Test
    void generateDown() {
        assertThat(directionDeterminer.next(false)).isEqualTo(Direction.DOWN);
    }

    @ParameterizedTest
    @CsvSource({
            "true,RIGHT_DOWN,LEFT_DOWN",
            "false,DOWN,DOWN"
    })
    void nextLast(String isLine, String firstDirection, String lastDirection) {
        assertThat(directionDeterminer.next(Boolean.parseBoolean(isLine))).isEqualTo(Direction.valueOf(firstDirection));
        assertThat(directionDeterminer.last()).isEqualTo(Direction.valueOf(lastDirection));
    }

    @Test
    void generateMultipleLine() {
        assertThat(directionDeterminer.next(true)).isEqualTo(Direction.RIGHT_DOWN);
        assertThat(directionDeterminer.next(false)).isEqualTo(Direction.LEFT_DOWN);
        assertThat(directionDeterminer.next(false)).isEqualTo(Direction.DOWN);
        assertThat(directionDeterminer.next(false)).isEqualTo(Direction.DOWN);
        assertThat(directionDeterminer.next(true)).isEqualTo(Direction.RIGHT_DOWN);
        assertThat(directionDeterminer.last()).isEqualTo(Direction.LEFT_DOWN);
    }

    @Test
    void throwExceptionIfTrueAndTrue() {
        directionDeterminer.next(true);

        assertThatIllegalArgumentException().isThrownBy(() -> directionDeterminer.next(true));
    }
}
