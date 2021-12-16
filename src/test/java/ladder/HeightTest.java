package ladder;

import ladder.domain.Height;
import ladder.exception.HeightException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class HeightTest {

    @Test
    void 사다리_높이는_숫자() {
        Assertions.assertThatThrownBy(() -> Height.of("숫자아님")).isInstanceOf(NumberFormatException.class);
    }

    @Test
    void 사다리_높이는_1이상() {
        Assertions.assertThatThrownBy(() -> Height.of("0")).isInstanceOf(HeightException.class);
    }
}
