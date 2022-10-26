package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoordinateTest {

    @DisplayName("생성할 때")
    @Nested
    class Create {

        @DisplayName("x,y 좌표를 지정할 수 있다.")
        @Test
        void specify() {
            Coordinate expected = new Coordinate(new Position(3), new Position(4));

            Coordinate actual = new Coordinate(3, 4);

            assertThat(actual).isEqualTo(expected);
        }
    }
}