package ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositionTest {

    @Test
    void create_fail() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Position(-1))
                .withMessage("position 은 음수일 수 없습니다.");
    }

    @Test
    void moveRight() {
        assertThat(new Position(0).moveRight()).isEqualTo(new Position(1));
    }

    @Test
    void moveLeft() {
        assertThat(new Position(1).moveLeft()).isEqualTo(new Position(0));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,0,true",
            "0,0,false",
            "0,1,false"
    })
    void isGreaterThan(Integer position1, Integer position2, Boolean expected) {
        assertThat(new Position(position1).isGreaterThan(position2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,0,false",
            "0,0,false",
            "0,1,true"
    })
    void isLesserThan(Integer position1, Integer position2, Boolean expected) {
        assertThat(new Position(position1).isLesserThan(position2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,0,true",
            "0,0,true",
            "0,1,false"
    })
    void isGreaterThanEqual(Integer position1, Integer position2, Boolean expected) {
        assertThat(new Position(position1).isGreaterThanEqual(position2)).isEqualTo(expected);
    }
}
