package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {

    @Test
    @DisplayName("포인트 생성")
    void test01() {
        Point point = new Point(true, false);

        assertThat(point).isEqualTo(new Point(true, false));
    }

    @Test
    @DisplayName("양쪽에 point 가 존재 시 에러 발생")
    void test02() {
        assertThatThrownBy(() -> new Point(true, true)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("왼쪽에 Point 가 존재 시 왼쪽으로 이동")
    void test03() {
        Point point = new Point(true, false);

        assertThat(point.move()).isEqualTo(-1);
    }

    @Test
    @DisplayName("오른쪽에 Point 가 존재 시 오른쪽으로 이동")
    void test04() {
        Point point = new Point(true, false);

        assertThat(point.move()).isEqualTo(-1);
    }

    @Test
    @DisplayName("양쪽에 Point 가 없으면 이동하지 않음")
    void test05() {
        Point point = new Point(false, false);

        assertThat(point.move()).isEqualTo(0);
    }
}
