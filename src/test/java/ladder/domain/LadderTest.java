package ladder.domain;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void generateLadder() {
        Ladder ladder = Ladder.from(1,2);
        People people = People.from("a,b,c");

        List<LadderLine> lines = ladder.generateLadder(getConditional());
        assertThat(lines.size()).isEqualTo(1);
    }

    private Conditional getConditional() {
        return people -> LadderLine.from(2);
    }
}
