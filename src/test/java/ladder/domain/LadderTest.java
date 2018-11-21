package ladder.domain;

import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void generateLadder() {
        Ladder ladder = Ladder.from(3);
        People people = People.from("a,b,c");

        ArrayList<Line> lines = ladder.generateLadder(people);
        assertThat(lines.size()).isEqualTo(3);
    }
}