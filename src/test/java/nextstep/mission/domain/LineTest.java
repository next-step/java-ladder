package nextstep.mission.domain;

import nextstep.mission.domain.Line;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @Test
    void constructor() {
        assertThat(new Line(Arrays.asList(true, false, true, false))).isEqualTo(new Line(Arrays.asList(true, false, true, false)));
    }

    @Test
    void constructorWithSize() {
        assertThat(new Line(4).checkSize(4)).isTrue();
    }

    @Test
    void constructorThrow() {
        assertThatThrownBy(() -> new Line(Arrays.asList(true, true, true, false)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void move() {
        Line line = new Line(Arrays.asList(false, true, false, true));
        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(0);
        assertThat(line.move(2)).isEqualTo(3);
        assertThat(line.move(3)).isEqualTo(2);
    }
}
