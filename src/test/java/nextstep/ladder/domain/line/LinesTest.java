package nextstep.ladder.domain.line;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LinesTest {

    @Test
    void of() {
        Lines lines = Lines.of(3, 4);

        Assertions.assertThat(lines).isNotNull();
        Assertions.assertThat(lines.getLines().size()).isEqualTo(3);
        Assertions.assertThat(lines.getLines().get(0).getPoints().size()).isEqualTo(4);
    }
}