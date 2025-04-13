package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LinesTest {
    @Test
    void getLinesTest() {
        Lines lines = new Lines(List.of(new Line(3, new FakeGeneratorStrategy(true))));

        assertThat(lines.getLines()).hasSize(1);
    }

    @Test
    void moveLinesTest() {
        Lines lines = new Lines(List.of(new Line(3, new FakeGeneratorStrategy(true))));

        Player sut = lines.moveLines(new Player("pobi", 0));

        assertThat(sut).isEqualTo(new Player("pobi", 1));
    }
}
