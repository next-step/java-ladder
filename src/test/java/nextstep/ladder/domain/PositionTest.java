package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositionTest {

    @DisplayName("Position은 위치값을 갖는다")
    @Test
    void position() {
        Assertions.assertThat(new Position(1)).isEqualTo(new Position(1));
    }
}
