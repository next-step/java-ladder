package nextstep.laddergame.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PointTest {

    @DisplayName("0, 1의 값으로 생성할 때 true, false로 생성되는지를 검증")
    @Test
    void numberConstructorTest() {
        assertThat(new Point(0)).isEqualTo(new Point(false));
        assertThat(new Point(1)).isEqualTo(new Point(true));
    }

    @DisplayName("empty 객체를 생성했을 때 false로 생성되는지 검증")
    @Test
    void emptyTest() {
        assertThat(Point.empty()).isEqualTo(new Point(false));
    }

    @DisplayName("true면 point가 있고, false면 point가 없음을 검증")
    @Test
    void hasLineTest() {
        assertThat(new Point(true).exist()).isEqualTo(true);
        assertThat(new Point(false).exist()).isEqualTo(false);
    }
}
