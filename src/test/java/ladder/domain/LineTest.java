package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @DisplayName("width 홀수로 Line 생성. LadderPart로 구성")
    @Test
    void create() {
        int width = 5;
        Line line = new Line(width);

        assertThat(line.width()).isEqualTo(width);
    }

    @DisplayName("width는 짝수 안됨.")
    @Test
    void create_even() {
        assertThatThrownBy(() -> new Line(6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("width는 짝수일 수 없습니다.");
    }

}
