package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
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

    @Test
    @DisplayName("사다리는 위치를 이동시킨다")
    void move() {
        Ladder ladder = getLadder();

        Position moved = ladder.move(Position.from(1));

        assertThat(moved).isEqualTo(Position.from(1));
    }

    public static Ladder getLadder() {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            lines.add(LineTest.getLine());
        }
        return new Ladder(lines);
    }
}