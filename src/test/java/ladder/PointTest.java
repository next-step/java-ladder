package ladder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static ladder.Point.POINT_MUST_HAS_ONLY_ONE_DIRECTION;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PointTest {
    @DisplayName("생성")
    @Nested
    class Create {
        @DisplayName("성공")
        @Test
        void success() {
            // given
            final int index = 0;
            final boolean left = true;
            final boolean right = false;

            // when
            final Point point = Point.of(index, left, right);

            // then
            assertThat(point).isNotNull();
        }

        @DisplayName("지점은 왼쪽 오른쪽 중 하나만 선택 가능")
        @Test
        void fail_when_has_two_direction() {
            // given
            final int index = 0;
            final boolean left = true;
            final boolean right = true;

            // when 
            final Throwable thrown = catchThrowable(() -> {
                Point.of(index, left, right);
            });

            // then
            Assertions.assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(POINT_MUST_HAS_ONLY_ONE_DIRECTION);
        }

        @DisplayName("방향이 없는 경우")
        @Test
        void return_empty_point_when_no_direction() {
            // given
            final int index = 0;
            final boolean left = false;
            final boolean right = false;

            // when
            final Point point = Point.of(index, left, right);

            // then
            assertThat(point).isNotNull();
        }
    }

    @DisplayName("현재 오른쪽 방향이 존재하는 경우 다음 오른쪽은 무조건 존재하지 않아야 한다.")
    @Test
    void next_right_should_false_when_now_points_right_is_true() {
        // given
        final int index = 0;
        final boolean left = false;
        final boolean right = true;
        final Point point = Point.of(index, left, right);

        // when
        final Point nextPoint = point.createNext(() -> true);

        // then
        assertThat(nextPoint.hasLeft()).isTrue();
        assertThat(nextPoint.hasRight()).isFalse();
    }

    @DisplayName("다음 지점의 오른쪽 라인이 무조건 생성 되지 않도록 만들어 진 경우")
    @Test
    void when_generator_is_only_generate_false_result() {
        // given
        final int index = 0;
        final boolean left = false;
        final boolean right = false;
        final Point point = Point.of(index, left, right);

        // when
        final Point nextPoint = point.createNext(() -> false);

        // then
        assertThat(nextPoint.hasLeft()).isFalse();
        assertThat(nextPoint.hasRight()).isFalse();
    }

    @DisplayName("다음 지점의 오른쪽 라인이 무조건 생성 되도록 만들어 진 경우")
    @Test
    void when_generator_is_only_generate_true_result() {
        // given
        final int index = 0;
        final boolean left = false;
        final boolean right = false;
        final Point point = Point.of(index, left, right);

        // when
        final Point nextPoint = point.createNext(() -> true);

        // then
        assertThat(nextPoint.hasLeft()).isFalse();
        assertThat(nextPoint.hasRight()).isTrue();
    }
}
