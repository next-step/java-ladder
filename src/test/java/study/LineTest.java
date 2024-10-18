package study;

import org.junit.jupiter.api.Test;
import study.core.Line;

import java.util.ArrayList;

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
}
