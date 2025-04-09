package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;

class LinesTest {
    @Test
    void getLinesTest() {
        Lines lines = new Lines(List.of(new Line(3, () -> new Random().nextBoolean())));

        assertThat(lines.getLines()).hasSize(1);
    }
}