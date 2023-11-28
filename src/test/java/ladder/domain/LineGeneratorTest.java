package ladder.domain;

import ladder.domain.data.Line;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class LineGeneratorTest {

    @Test
    void 값이_모두_true_일때_사다리가_겹침_여부_확인() {
        LineGenerator lineGenerator = new LineGenerator(new AlwaysTrueGenerator());
        Line line = lineGenerator.generate(3);
        assertThat(line).isEqualTo(new Line("|-| |"));
    }

    @Test
    void custom_boolean_값() {
        LineGenerator lineGenerator = new LineGenerator(new CustomBooleanGenerator(FALSE, TRUE));
        Line line = lineGenerator.generate(3);
        assertThat(line).isEqualTo(new Line("| |-|"));
    }

}
