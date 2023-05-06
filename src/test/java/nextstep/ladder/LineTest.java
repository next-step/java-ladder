package nextstep.ladder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {

    @Test
    void getPoints() {
        List<Boolean> expect = List.of(true, false, false, true);
        Line line = new Line(expect);
        assertThat(line.getPoints())
                .isEqualTo(expect);
    }

    @Test
    void 잘못된사다리() {
        List<Boolean> line = List.of(true, true, false, false);
        assertThatThrownBy(() -> new Line(line))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 사다리입니다.");
    }
}