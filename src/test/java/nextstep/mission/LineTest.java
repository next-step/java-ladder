package nextstep.mission;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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
}
