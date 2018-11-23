package ladder.domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void generateLadder() {
        Ladder ladder = Ladder.from(3);
        People people = People.from("a,b,c");

        List<Line> lines = ladder.generateLadder(people, getConditional());
        assertThat(lines.size()).isEqualTo(3);
    }

    private Conditional getConditional() {
        return people -> Line.from(people.peopleCount());
    }
}