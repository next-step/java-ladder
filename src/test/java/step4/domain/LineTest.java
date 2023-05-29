package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @DisplayName("아래로 이동")
    @Test
    public void moveToDown() {
        Line line = new Line(List.of(false));
        assertThat(line.nextPosition(0)).isEqualTo(0);
    }

    @DisplayName("좌측으로 이동")
    @Test
    public void moveToLeft() {
        Line line = new Line(List.of(true));
        assertThat(line.nextPosition(1)).isEqualTo(0);
    }

    @DisplayName("우측으로 이동")
    @Test
    public void moveToRight() {
        Line line = new Line(List.of(true));
        assertThat(line.nextPosition(0)).isEqualTo(1);
    }
}
