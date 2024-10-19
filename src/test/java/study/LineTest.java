package study;

import org.junit.jupiter.api.Test;
import study.core.Line;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @Test
    void getPoints_수정가능여부확인() {
        Line line = new Line(new ArrayList<>());
        line.createPoints(5);
        assertThatThrownBy(() -> line.getPoints().set(0, true))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> line.getPoints().add(true))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> line.getPoints().remove(0))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void create() {
        Line line = new Line(new ArrayList<>());
        line.createPoints(5);
        assertThat(line.getPoints().size()).isEqualTo(4);
    }

    @Test
    void move() {
        Line line = new Line(List.of(true, false, true));
        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
        assertThat(line.move(2)).isEqualTo(3);
        assertThat(line.move(3)).isEqualTo(2);
    }
}
