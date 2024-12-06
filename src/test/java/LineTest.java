import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void create() {
        assertThat(new Line(0, DotType.NODE, DotType.BRIDGE, DotType.NODE))
                .isEqualTo(new Line(0, DotType.NODE, DotType.BRIDGE, DotType.NODE));
    }
}
