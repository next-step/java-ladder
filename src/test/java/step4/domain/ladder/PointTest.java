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

    @Nested
    @DisplayName("다음 Point 생성할 수 있다.")
    class createNextTest {

        @Test
        @DisplayName("이전 Point의 right-true일 때 항상 direction이 ture-false다.")
        void prevPointRightTrueTest() {

            // given
            Direction direction = Direction.from(false, true);
            Point prev = Point.from(1, direction);
            Point expected = Point.from(2, Direction.from(true, false));

            // when
            Point result = prev.next(() -> true);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Nested
        @DisplayName("이전 Point가 right-false일 때")
        class prevPointRightFalseTest {

            // given
            Direction direction = Direction.from(false, false);
            Point prev = Point.from(1, direction);

            @Test
            @DisplayName("true direction")
            void trueTest() {

                // given
                Point expected = Point.from(2, Direction.from(false, true));

                // when
                Point result = prev.next(() -> true);

                // then
                assertThat(result).isEqualTo(expected);
            }

            @Test
            @DisplayName("false direction")
            void falseTest() {

                // given
                Point expected = Point.from(2, Direction.from(false, false));

                // when
                Point result = prev.next(() -> false);

                // then
                assertThat(result).isEqualTo(expected);
            }
        }
    }

    @Nested
    @DisplayName("마지막 Point 생성할 수 있다.")
    class createLastPointTest {

        @Test
        @DisplayName("이전 Point와 연결되어있을 때 left가 true이다.")
        void trueTest() {

            // given
            Point prev = Point.from(2, Direction.from(false, true));
            Point expected = Point.from(3, Direction.from(true, false));

            // when
            Point result = prev.last();

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("이전 Point와 연결되어있지 않을때 left가 false이다.")
        void falseTest() {

            // given
            Point prev = Point.from(2, Direction.from(false, false));
            Point expected = Point.from(3, Direction.from(false, false));

            // when
            Point result = prev.last();

            // then
            assertThat(result).isEqualTo(expected);
        }
    }

    @Test
    @DisplayName("오른쪽으로 연결되어있으면 오른쪽으로 이동할 수 있다.")
    void moveRightTest() {

        // given
        Point prev = Point.first(() -> false);
        Point now = prev.next(() -> true);
        Point next = now.last();
        int expected = 2;

        // when
        int result = now.move();

        // then
        assertThat(result).isEqualTo(expected);
    }

}