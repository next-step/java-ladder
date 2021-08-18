package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    @DisplayName("사람 수-1만큼 라인이 생성되어야함.")
    @Test
    void create() {
        Line line = new Line(5);
        assertThat(line.getPoints().size()).isEqualTo(4);
        System.out.println(line.getPoints());
    }

}