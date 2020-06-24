package nextstep.step2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.Boolean.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    @Test
    void getLines() {
        Lines lines = Lines.of(10);
        List<Line> newLines = lines.createLines(10);
        assertThat(newLines.size()).isEqualTo(9);
    }
}
