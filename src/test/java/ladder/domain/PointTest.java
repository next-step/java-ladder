package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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

    @DisplayName("기본 방향 제너레이터를 통해 Direction 만들기")
    @Test
    void crate_using_default_generator() {
        // given
        final int index = 0;
        final boolean left = false;
        final boolean right = false;
        final Point point = Point.of(index, left, right);

        // when
        final Point nextPoint = point.createNext();

        // then
        assertThat(nextPoint).isNotNull();
    }

    @DisplayName("첫 번째 Point 만들기")
    @Test
    void create_first_point_using_generator() {
        // when
        final Point nextPoint = Point.createFirst(() -> true);

        // then
        assertThat(nextPoint.hasLeft()).isFalse();
        assertThat(nextPoint.hasRight()).isTrue();
    }

    @DisplayName("기본 방향 제너레이터를 통해 첫 번째 Direction 만들기")
    @Test
    void create_first_point_using_default_generator() {
        // when
        final Point nextPoint = Point.createFirst();

        // then
        assertThat(nextPoint).isNotNull();
    }
    
    @DisplayName("마지막 Point 만들기")
    @Test
    void create_last_point() {
        // given
        final int index = 0;
        final boolean left = false;
        final boolean right = true;
        final Point point = Point.of(index, left, right);
        
        // when
        final Point nextPoint = point.createLast();

        // then
        assertThat(nextPoint.hasLeft()).isTrue();
        assertThat(nextPoint.hasRight()).isFalse();
    }
}
