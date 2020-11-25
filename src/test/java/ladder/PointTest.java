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
            final boolean horizontal = true;
            final boolean vertical = false;

            // when
            final Point point = Point.of(index, horizontal, vertical);

            // then
            assertThat(point).isNotNull();
        }

        @DisplayName("지점은 가로 세로 중 하나만 선택 가능")
        @Test
        void fail_when_has_two_direction() {
            // given
            final int index = 0;
            final boolean horizontal = true;
            final boolean vertical = true;

            // when 
            final Throwable thrown = catchThrowable(() -> {
                Point.of(index, horizontal, vertical);
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
            final boolean horizontal = false;
            final boolean vertical = false;

            // when
            final Point point = Point.of(index, horizontal, vertical);

            // then
            assertThat(point).isNotNull();
            assertThat(point).isEqualTo(Point.createEmpty(index));
        }

        @DisplayName("empty 생성")
        @Test
        void createEmpty() {
            // given
            final int index = 0;

            // when
            final Point point = Point.createEmpty(index);

            // then
            assertThat(point).isNotNull();
        }
    }
}
