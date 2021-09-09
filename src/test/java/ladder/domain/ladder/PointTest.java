package ladder.domain.ladder;

import static ladder.domain.ladder.Point.createFirst;
import static ladder.domain.ladder.Point.createLast;
import static ladder.domain.ladder.Point.createNextByBeforePoint;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PointTest {

    @Nested
    @DisplayName("첫번째 Point 객체를 만들 수 있다.")
    class createFirstTest {

        @Test
        @DisplayName("[connected = true]")
        void trueConnected() {

            // given
            Point expected = new Point(0, false, true);

            // when
            Point result = createFirst(() -> true);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("[connected = false]")
        void falseConnected() {

            // given
            Point expected = new Point(0, false, false);

            // when
            Point result = createFirst(() -> false);

            // then
            assertThat(result).isEqualTo(expected);
        }

    }

    @Nested
    @DisplayName("첫번째 Point 객체를 만들 수 있다.")
    class createLastTest {

        @Test
        @DisplayName("[prevconnected = true]")
        void trueConnected() {

            // given
            Point now = new Point(3, false, true);
            Point expected = new Point(4, true, false);

            // when
            Point result = createLast(now);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("[prevconnected = false]")
        void falseConnected() {

            // given
            Point now = new Point(3, false, false);
            Point expected = new Point(4, false, false);

            // when
            Point result = createLast(now);

            // then
            assertThat(result).isEqualTo(expected);
        }

    }

    @Nested
    @DisplayName("다음 Point 객체를 만들 수 있다.")
    class createNextPointTest {

        @Test
        @DisplayName("[prev connected = true]")
        void trueConnected() {

            // given
            int index = 6;
            Point nowPoint = new Point(index, false, true);
            Random random = new Random();
            Point expected = new Point(index + 1, true, false);

            // when
            Point result = createNextByBeforePoint(nowPoint, () -> random.nextBoolean());

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Nested
        @DisplayName("[prev connected = false]")
        class prevConnectFalse {

            @Test
            @DisplayName("[next connected = true]")
            void trueNext() {

                // given
                int index = 6;
                Point nowPoint = new Point(index, false, false);
                Point expected = new Point(index + 1, false, true);

                // when
                Point result = createNextByBeforePoint(nowPoint, () -> true);

                // then
                assertThat(result).isEqualTo(expected);
            }

            @Test
            @DisplayName("[next connected = false]")
            void falseNext() {

                // given
                int index = 6;
                Point nowPoint = new Point(index, false, false);
                Point expected = new Point(index + 1, false, false);

                // when
                Point result = createNextByBeforePoint(nowPoint, () -> false);

                // then
                assertThat(result).isEqualTo(expected);
            }

        }

    }

    @Test
    @DisplayName("Last Point를 생성할 때 이전 Point가 null로 들어오면 Exception이 발생되어야 한다.")
    void createLastPointFailByNullBeforePointTest() {

        // given
        Point before = null;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> createLast(before))
            .withMessageMatching("이전 위치한 Point가 제공되어야 한다.");
    }

    @Test
    @DisplayName("다음 Point를 생성할 때 이전 Point가 null로 들어오면 Exception이 발생되어야 한다.")
    void createNextPointFailByNullBeforePointTest() {

        // given
        Point before = null;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> createNextByBeforePoint(before, () -> true))
            .withMessageMatching("이전 위치한 Point가 제공되어야 한다.");
    }

    @Nested
    @DisplayName("오른쪽 연결이")
    class nextConnect {

        @Test
        @DisplayName("연결되어 있다면 true를 반환할 수 있다.")
        void trueTest() {

            // given
            Point point = new Point(1, false, true);

            // when
            boolean result = point.isNextConnect();

            // then
            assertTrue(result);
        }

        @Test
        @DisplayName("연결되어있지 않다면 false를 반환할 수 있다.")
        void falseTest() {

            // given
            Point point = new Point(1, false, false);

            // when
            boolean result = point.isNextConnect();

            // then
            assertFalse(result);
        }

    }

    @Nested
    @DisplayName("왼쪽 연결이")
    class prevConnect {

        @Test
        @DisplayName("연결되어 있다면 true를 반환할 수 있다.")
        void trueTest() {

            // given
            Point point = new Point(1, true, false);

            // when
            boolean result = point.isPrevConnect();

            // then
            assertTrue(result);
        }

        @Test
        @DisplayName("연결되어있지 않다면 false를 반환할 수 있다.")
        void falseTest() {

            // given
            Point point = new Point(1, false, false);

            // when
            boolean result = point.isPrevConnect();

            // then
            assertFalse(result);
        }

    }

}