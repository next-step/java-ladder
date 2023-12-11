package ladder.gilbert;

import ladder.engine.Line;
import ladder.engine.LineGenerator;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class GilbertLineGeneratorTest {

    @Test
    void 값이_모두_true_일때_사다리가_겹침_여부_확인() {
        LineGenerator lineGenerator = new GilbertLineGenerator(new AlwaysTrueGenerator());
        Line line = lineGenerator.generate(3);
        assertThat(line).isEqualTo(new GilbertLine("|-| |"));
    }

    @Test
    void custom_boolean_값() {
        LineGenerator lineGenerator = new GilbertLineGenerator(new CustomBooleanGenerator(FALSE, TRUE, FALSE, FALSE));
        Line line = lineGenerator.generate(5);
        assertThat(line).isEqualTo(new GilbertLine("| |-| | |"));
    }

}
