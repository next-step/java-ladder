package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LineTest {

    @DisplayName("참가자 수를 전달하면 Line 객체를 생성한다.")
    @Test
    void lineTest() {
        assertThat(new Line(3)).isInstanceOf(Line.class);
    }

    @DisplayName("참 거짓으로 구성된 리스트를 전달하면 Line 객체를 생성한다.")
    @Test
    void lineListTest() {
        assertThat(new Line(List.of(true, false, true, false))).isInstanceOf(Line.class);
    }

    @DisplayName("참 거짓으로 구성된 리스트 중 참이 연달아 들어간 리스트를 전달하면 IllegalArgumentException을 던진다.")
    @Test
    void lineExceptionTest() {
        assertThatThrownBy(() -> new Line(List.of(false, true, true)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
