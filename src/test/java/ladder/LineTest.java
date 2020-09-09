package ladder;

import ladder.domain.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @DisplayName("라인 생성되는지")
    public void isLineGenerated() {
        Line line = new Line(1);

        List<Boolean> expected = new ArrayList<>();
        expected.add(Boolean.FALSE);

        assertThat(line.getLine()).isEqualTo(expected);
    }

}
