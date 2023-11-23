package nextstep.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {
    @Test
    @DisplayName("왼쪽, 오른쪽 각각의 사다리 존재 유무를 입력으로, Point 클래스를 생성한다.")
    void testPointConstructor() {
        //given, when
        Point point = new Point(true, false);

        //then
        assertThat(point).isNotNull();
    }

    @Test
    @DisplayName("왼쪽, 오른쪽 각각의 사다리 존재 유무 입력으로 true, true 를 넣게 되면, IllegalArgumentException이 발생한다.")
    void testPointConstructorWithTrueTrue() {
        //given, when, then
        assertThatThrownBy(() -> new Point(true, true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양쪽에 사다리가 존재할 수 없습니다.");
    }
}
