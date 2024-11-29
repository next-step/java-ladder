import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void create() {
        assertThat(new Line(DotType.NODE, DotType.BRIDGE, DotType.NODE))
                .isEqualTo(new Line(DotType.NODE, DotType.BRIDGE, DotType.NODE));
    }
}
