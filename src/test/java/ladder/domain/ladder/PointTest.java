package ladder.domain.ladder;

import static ladder.domain.ladder.Point.createFirst;
import static ladder.domain.ladder.Point.createLast;
import static ladder.domain.ladder.Point.createNextByBeforePoint;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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
            Point expected = new Point(0, false,false);

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
        @DisplayName("[connected = false]")
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
        @DisplayName("[before connected = true]")
        void trueConnected() {

            // given
            int index = 6;
            Point nowPoint = new Point(index, true);
            Random random = new Random();
            Point expected = new Point(index + 1, false);

            // when
            Point result = createNextByBeforePoint(nowPoint, () -> random.nextBoolean());

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("[before connected = false]")
        void falseConnected() {

            // given
            int index = 6;
            Point nowPoint = new Point(index, false);
            Random random = new Random();
            Point expected = new Point(index + 1, true);

            // when
            Point result = createNextByBeforePoint(nowPoint, () -> true);

            // then
            assertThat(result).isEqualTo(expected);
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

}