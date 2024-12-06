import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PointTest {
    @Test
    void create() {
        assertThat(new Point(1, 1)).isEqualTo(new Point(1, 1));
    }
}
