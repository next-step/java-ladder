package ladder;

import ladder.domain.Lines;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    private Lines lines;

    @BeforeEach
    void setUp() {
        String input = "tom,base,yeahs";
        lines = new Lines(5, input);
    }

    @Test
    void LinesTest() {
        assertThat(lines.getLadderLines()).hasSize(5);
    }

    @Test
    void linesWithParameterTest() {
        String input = "a,b,c,iron_man";
        Lines lines1 = new Lines(5, input);
        assertThat(lines1.getLadderLines()).hasSize(5);
        assertThat(lines1.getPeople()).contains("a", "b", "c");
    }
}
