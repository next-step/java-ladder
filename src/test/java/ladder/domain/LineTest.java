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

    @DisplayName("생성된 Line 객체에 인덱스를 전달하면 움직일 방향을 반환한다.(1이면 오른쪽, -1이면 왼쪽, 0이면 그대로)")
    @Test
    void moveTest() {
        Line line = new Line(List.of(true, false, true, false));

        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(-1);
        assertThat(line.move(4)).isEqualTo(0);
    }
}
