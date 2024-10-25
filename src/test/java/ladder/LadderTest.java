package ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    InformationForGame informationForGame;

    @BeforeEach
    public void setUp() {
        String participants = "Alice,Bob,Charlie";
        String ladderCount = "5";

        informationForGame = new InformationForGame(participants, ladderCount);
        informationForGame.createLines();
    }

    @Test
    public void createLineForLadder() {
        assertThat(informationForGame.getLines()).hasSize(5);
    }

    @Test
    public void createLineForParticipant() {
        int expectedLineSize = informationForGame.getParticipants().size() - 1;
        for (Line line : informationForGame.getLines()) {
            assertThat(line.size()).isEqualTo(expectedLineSize);
        }
    }



}
