import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DotTest {
    @Test
    void create() {
        assertThat((new Dot(0, 0, DotType.NODE)).moveDown()).isEqualTo(new Dot(0, 1, DotType.NODE));
    }

    @Test
    void invalid() {
        assertThatThrownBy(
                () -> (new Dot(1, 0, DotType.BRIDGE)).playerNumber()
        ).isInstanceOf(RuntimeException.class);
    }
}
