package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @DisplayName("사다리 라인을 만들 수 있다.")
    @Test
    void create() {
        Line line = new Line(List.of(true));

        assertThat(line).isEqualTo(new Line(List.of(true)));
    }

    @DisplayName("3명 사이에서 사다리 라인 2개를 만들 수 있다.")
    @Test
    void createTwoLine() {
        Line line = new Line(3, () -> true);

        assertThat(line).isEqualTo(new Line(List.of(true, false)));
    }

    @DisplayName("6명 사이에서 사다리 라인 5개를 만들 수 있다.")
    @Test
    void createThreeLine() {
        Line line = new Line(6, () -> true);

        assertThat(line).isEqualTo(new Line(List.of(true, false, true, false, true)));
    }
}
