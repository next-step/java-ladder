package ladder.domain.line.v2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @ParameterizedTest
    @CsvSource(value = {
            "RIGHT,true",
            "LEFT,false",
            "NONE,false",
    })
    void isRight(Direction direction, boolean expected) {
        assertThat(direction.isRight()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "RIGHT,false",
            "LEFT,true",
            "NONE,false",
    })
    void isLeft(Direction direction, boolean expected) {
        assertThat(direction.isLeft()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "true,RIGHT",
            "false,NONE"
    })
    void first(boolean hasRight, Direction expected) {
        assertThat(Direction.first(hasRight)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "RIGHT,true,LEFT",
            "RIGHT,false,LEFT",
            "LEFT,true,RIGHT",
            "LEFT,false,NONE",
            "NONE,true,RIGHT",
            "NONE,false,NONE",
    })
    void next(Direction direction, boolean hasRight, Direction expected) {
        assertThat(direction.next(hasRight)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "RIGHT,LEFT",
            "LEFT,NONE",
            "NONE,NONE",
    })
    void last(Direction direction, Direction expected) {
        assertThat(direction.last()).isEqualTo(expected);
    }
}
