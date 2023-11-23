package nextstep.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PointTest {
    @Test
    @DisplayName("왼쪽, 오른쪽 각각의 사다리 가로대 존재유무를 입력으로, Point 클래스를 생성한다.")
    void testPointConstructor() {
        //given, when
        Point point = new Point(true, false);

        //then
        assertThat(point).isNotNull();
    }
}
