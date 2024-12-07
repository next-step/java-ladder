import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CrossTest {
    @Test
    void move() {
        assertThat(Cross.first(true, 0).move(new Pos(0, 0))).isEqualTo(new Pos(1, 0));
        assertThat(Cross.first(false, 0).add(true).move(new Pos(1, 0))).isEqualTo(new Pos(2, 0));
        assertThat(Cross.first(false, 0).add(false).move(new Pos(1, 0))).isEqualTo(new Pos(1, 1));
        assertThatThrownBy(() -> Cross.first(true, 0).add(true)).isInstanceOf(IllegalArgumentException.class);
    }
}
