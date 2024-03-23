package nextstep.ladder.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    void create() {
        int height = 2;
        int countOfPerson = 4;

        Ladder ladder = Ladder.from(height, countOfPerson);
        assertThat(ladder.height()).isEqualTo(height);
    }

    @Test
    void equals() {
        Line line1 = Line.from(3);
        Line line2 = Line.from(3);
        Line line3 = Line.from(3);

        List<Line> lines = Arrays.asList(line1, line2, line3);
        Ladder ladder = Ladder.from(lines);

        assertThat(ladder)
                .isEqualTo(Ladder.from(Arrays.asList(line1, line2, line3)));
    }
}
