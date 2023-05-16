package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
class LadderTest {

    @Test
    void ofHeightAndCountOfPerson() {
        Ladder actual = Ladder.ofHeightAndCountOfPerson(5, 4, () -> false);
        Ladder expected = getLadder();

        assertThat(actual).isEqualTo(expected);
    }

    private Ladder getLadder() {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            lines.add(LineTest.getLine());
        }
        return new Ladder(lines);
    }
}