package ladder.domain.engine;

import ladder.domain.impl.LadderCreatorImpl;
import ladder.domain.impl.RandomLineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderCreatorTest {

    @DisplayName("사다리를 생성할 수 있다.")
    @Test
    void createTest() {
        int heightOfLadder = 5;
        int numberOfPlayers = 4;

        LineGenerator lineGenerator = new RandomLineGenerator();
        LadderCreator ladderCreator = new LadderCreatorImpl(lineGenerator);
        Ladder ladder = ladderCreator.create(heightOfLadder, numberOfPlayers);

        assertThat(ladder.lines()).hasSize(heightOfLadder);
    }
}