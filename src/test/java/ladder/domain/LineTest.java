package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LineTest {
    @DisplayName("사람 수-1만큼 라인이 생성되어야함.")
    @Test
    void create() {
        Line line = new Line(5);
        assertThat(line.size()).isEqualTo(4);
        System.out.println(line.toString());
    }

    @DisplayName("1명은 플레이 불가능")
    @Test
    void error() {
        assertThatThrownBy(() -> new Line(1)).isInstanceOf(IllegalArgumentException.class);
    }

}