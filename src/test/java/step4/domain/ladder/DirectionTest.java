package step4.domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import step4.exception.ladder.DirectionConnectException;

class DirectionTest {

    @Test
    @DisplayName("첫번째 좌표 right-true를 생성할 수 있다.")
    void createFirstTrueTest() {

        // given
        Direction expected = Direction.from(false, true);

        // when
        Direction result = Direction.first(() -> true);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("첫번째 좌표 right-false를 생성할 수 있다.")
    void createFirstFalseTest() {

        // given
        Direction expected = Direction.from(false, false);

        // when
        Direction result = Direction.first(() -> false);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("현재 Direction right-true을 가지고 다음 Direction을 생성할 수 있다.")
    void createNextRightByTrueTest() {

        // given
        Direction first = Direction.first(() -> true);
        Direction expected = Direction.from(true, false);

        // when
        Direction result = first.next(() -> true);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Nested
    @DisplayName("현재 Direction right-false를 가지고")
    class DirectionRightFalse {

        // given
        Direction first = Direction.first(() -> false);

        @Test
        @DisplayName("다음 Direction right-true를 생성할 수 있다.")
        void createNextRightTrueTest() {

            // given
            Direction expected = Direction.from(false, true);

            // when
            Direction result = first.next(() -> true);

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        @DisplayName("다음 Direction right-false를 생성할 수 있다.")
        void createNextRightFalseTest() {

            // given
            Direction expected = Direction.from(false, false);

            // when
            Direction result = first.next(() -> false);

            // then
            assertThat(result).isEqualTo(expected);
        }
    }

    @Test
    @DisplayName("현재 Direction을 가지고 마지막 Direction을 생성할 수 있다.")
    void createLastDirectionTest() {

        // given
        Direction direction = Direction.from(false, true);
        Direction expected = Direction.from(true, false);

        // when
        Direction result = direction.last();

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("왼쪽 오른쪽이 둘다 true인 방향 그래프가 나오면 exception이 발생해야 한다.")
    void leftRightTrueExceptionTest() {

        // when & then
        assertThatExceptionOfType(DirectionConnectException.class)
            .isThrownBy(() -> Direction.from(true, true))
            .withMessageMatching("왼쪽 오른쪽 둘 다 연결될 수 없다.");
    }

    @Test
    @DisplayName("equals, hashcode 테스트")
    void equalsHashCodeTest() {

        // given
        Direction direction = Direction.from(false, true);
        Direction copyDirection = Direction.from(false, true);

        // when & then
        assertThat(direction)
            .isEqualTo(copyDirection)
            .hasSameHashCodeAs(copyDirection);
    }

}