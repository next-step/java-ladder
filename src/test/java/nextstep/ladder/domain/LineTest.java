package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LineTest {
    @Test
    void of() {
        Line actual = Line.of(4, () -> false);
        Line expected = getLine();

        assertThat(actual).isEqualTo(expected);
    }

    public static Line getLine() {
        List<Boolean> expected = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            expected.add(false);

        }
        return new Line(expected);
    }
}