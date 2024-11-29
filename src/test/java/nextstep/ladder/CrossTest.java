package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CrossTest {

    @Test
    void right() {
        Cross cross = new Cross(0, Point.first(true));
        assertThat(cross.move()).isEqualTo(1);
    }

    @Test
    void left() {
        Cross cross = new Cross(1, Point.first(true).next(false));
        assertThat(cross.move()).isEqualTo(0);
    }

    @Test
    void down() {
        Cross cross = new Cross(0, Point.first(true).next(false).last());
        assertThat(cross.move()).isEqualTo(0);
    }
}
