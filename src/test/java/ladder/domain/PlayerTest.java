package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @DisplayName("생성할 때")
    @Nested
    class Create {

        @DisplayName("이름과 좌표를 지정할 수 있다.")
        @Test
        void specify_name_coordinate() {
            Player expected = new Player(new Name("apple"), new Coordinate(3, 4));

            Player actual = new Player("apple", 3, 4);

            assertThat(actual).isEqualTo(expected);
        }
    }
}
