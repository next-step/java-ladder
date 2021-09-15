package step4.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PointTest {

    @Nested
    @DisplayName("첫번째 Point를 생성할 수 있다.")
    class createPointTest {

        @Test
        @DisplayName("true direction")
        void trueTest() {

            // given
            Direction direction = Direction.from(false, true);
            Point exepcted = Point.from(0, direction);

            // when
            Point result = Point.first(() -> true);

            // then
            assertThat(result).isEqualTo(exepcted);
        }

        @Test
        @DisplayName("false direction")
        void falseTest() {

            // given
            Direction direction = Direction.from(false, false);
            Point exepcted = Point.from(0, direction);

            // when
            Point result = Point.first(() -> false);

            // then
            assertThat(result).isEqualTo(exepcted);
        }
    }

}