package ladder;

import nextstep.optional.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static nextstep.optional.User.ageIsInRange1;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    private Ladder ladder;

    @BeforeEach
    public void setUp() {
        ladder = new Ladder("Alice,Bob,Cha", "5");

    }

    @Test
    public void createLineForLadder() {
        ladder.createLines();
        assertThat(ladder.getLines()).hasSize(5);
    }

    @Test
    public void createLineForParticipant() {
        ladder.createLines();
        int expectedLineSize = ladder.getParticipants().size() - 1;
        for (Line line : ladder.getLines()) {
            assertThat(line.size()).isEqualTo(expectedLineSize);
        }
    }

    @Test
    public void createInitialLine() {
        Line line = new Line(5);
        for (Boolean lines : line.getLines()) {
            assertThat(lines).isFalse();
        }
    }

    @Test
    public void createRandomLines() {
        ladder.createLines();
        List<Boolean> lineStates = ladder.getLines().get(0).getLines();
        assertThat(lineStates).containsAnyOf(true, false);
    }
}
