package ladder.domain;

import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void generateLadder() {
        Ladder ladder = new Ladder(3);
        People people = new People("a,b,c");

        ArrayList<Line> lines = ladder.generateLadder(people);
        assertThat(lines.size()).isEqualTo(3);
    }
}