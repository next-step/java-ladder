package nextstep.ladder.domain.line;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    void of() {
        Line line = Line.of(4);

        Assertions.assertThat(line).isNotNull();
    }
}