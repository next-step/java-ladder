package ladder.domain.type;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTypeTest {
    @ParameterizedTest
    @CsvSource(value = {"true:RIGHT", "false:DOWN"}, delimiter = ':')
    void first(boolean value, DirectionType expected) {
        DirectionType actual = DirectionType.first(value);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"RIGHT:LEFT", "LEFT:DOWN", "DOWN:DOWN"}, delimiter = ':')
    void last(DirectionType type, DirectionType expected) {
        DirectionType actual = type.last();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void next() {
        DirectionType actualRight = DirectionType.RIGHT.next();
        DirectionType actualLeft = DirectionType.LEFT.next();

        assertThat(actualRight).isEqualTo(DirectionType.LEFT);
        assertThat(actualLeft).isNotEqualTo(DirectionType.LEFT);
    }
}

