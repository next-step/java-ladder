package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    void create() {
        Line line = new Line(List.of(true, false, true));
        Ladder ladder = new Ladder(4, 2, personCount -> line);

        assertThat(ladder).isEqualTo(new Ladder(List.of(line, line)));
    }
}
