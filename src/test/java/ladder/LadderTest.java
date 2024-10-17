package ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    void 생성() {
        List<Line> lines = List.of(
            new Line(2, new FixedLineGenerator()),
            new Line(2, new FixedLineGenerator()),
            new Line(2, new FixedLineGenerator())
        );
        Ladder ladder = new Ladder(lines);

        assertThat(ladder).isEqualTo(new Ladder(lines));
    }
}
