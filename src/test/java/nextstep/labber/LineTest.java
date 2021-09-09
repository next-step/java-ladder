package nextstep.labber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("오른쪽으로 이동")
    void move_right() {
        Line line = new Line(Arrays.asList(false , true, false)) ;

        assertThat(line.move(1)).isEqualTo(Compass.RIGHT);
    }

    @Test
    @DisplayName("왼쪽으로 이동")
    void move_left() {
        Line line = new Line(Arrays.asList(true , false, false)) ;

        assertThat(line.move(1)).isEqualTo(Compass.LEFT);
    }

    @Test
    @DisplayName("아래로 이동")
    void move_down() {
        Line line = new Line(Arrays.asList(false , false, false)) ;

        assertThat(line.move(1)).isEqualTo(Compass.DOWN);
    }
}