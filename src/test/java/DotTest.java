import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DotTest {
    @Test
    void move() {
        assertThat(new Dot(false, false).move()).isEqualTo(Direction.PASS);
        assertThat(new Dot(true, false).move()).isEqualTo(Direction.LEFT);
        assertThat(new Dot(false, true).move()).isEqualTo(Direction.RIGHT);
        assertThatThrownBy(() -> new Dot(true, true)).isInstanceOf(IllegalArgumentException.class);
    }
}
