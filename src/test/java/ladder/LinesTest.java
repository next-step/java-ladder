package ladder;

import ladder.model.Line;
import ladder.model.Lines;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    private static final int LINE_COUNT = 2;

    Lines lines = new Lines();

    @BeforeEach
    void setting() {
        List<Boolean> line1Point = new ArrayList<>();
        line1Point.add(true);
        line1Point.add(true);
        line1Point.add(false);
        lines.addLine(new Line(line1Point));
        List<Boolean> line2Point = new ArrayList<>();
        line1Point.add(false);
        line1Point.add(false);
        line1Point.add(false);
        lines.addLine(new Line(line2Point));
    }

    @Test
    void 라인수체크() {
        assertThat(lines.getLineList().size()).isEqualTo(LINE_COUNT);
    }


}
