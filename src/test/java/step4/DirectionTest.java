package step4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class DirectionTest {
    @Test
    public void init() {
        Assertions.assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
    }

}
