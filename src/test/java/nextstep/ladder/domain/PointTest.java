package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {

    @DisplayName("인덱스는 0보다 작을 수 없다")
    @Test
    void negativeIndex() {
        assertThatThrownBy(() -> new Point(-1, false, false))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("좌 우 모두 이동 가능한 Point는 생성할 수 없다")
    @Test
    void invalidPoint() {
        assertThatThrownBy(() -> new Point(1, true, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Point는 좌 우 이동 가능 여부를 가진다")
    @ParameterizedTest(name = "좌 이동: {0}, 우 이동: {1})")
    @CsvSource(value = {"true,false", "false,true", "false,false"})
    void create(boolean left, boolean right) {
        Point point = new Point(1, left, right);

        assertThat(point.canMoveLeft()).isEqualTo(left);
        assertThat(point.canMoveRight()).isEqualTo(right);
    }

    @DisplayName("가장 왼쪽 포인트는 왼쪽으로 이동할 수 없다")
    @Test
    void createLeftmost() {
        Point point = Point.createLeftmost(true);

        assertThat(point.canMoveLeft()).isFalse();
    }

    @DisplayName("가장 오른쪽 포인트는 오른쪽으로 이동할 수 없다")
    @Test
    void createRightmost() {
        Point point = new Point(1, false, true).createRightmost();

        assertThat(point.canMoveRight()).isFalse();
    }

    @DisplayName("인덱스가 같은지 비교")
    @ParameterizedTest(name = "index = {0}, targetIndex = {1}, expected = {2}")
    @CsvSource(value = {"0,0,true", "1,0,false"})
    void sameIndex(int index, int targetIndex, boolean expected) {
        Point point = new Point(index, false, false);

        assertThat(point.sameIndex(targetIndex)).isEqualTo(expected);
    }
}
