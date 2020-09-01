package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    @DisplayName("Point 생성시 Line을 make 할 수 있는지 여부 테스트")
    public void can_make_test() {
        // given
        Point point = new Point();

        // when & then
        assertThat(point.canMake()).isTrue();
    }

    @Test
    @DisplayName("왼쪽에 라인을 make 했을 때 제대로 생성 되는지 테스트")
    public void make_on_left_test() {
        // given
        Point point = new Point();

        // when
        point.makeOnLeft();

        // then
        assertThat(point.hasLeft()).isTrue();
    }

    @Test
    @DisplayName("오른쪽에 라인을 make 했을 때 제대로 생성 되는지 테스트")
    public void make_on_right_test() {
        // given
        Point point = new Point();

        // when
        point.makeOnRight();

        // then
        assertThat(point.hasRight()).isTrue();
    }

}
