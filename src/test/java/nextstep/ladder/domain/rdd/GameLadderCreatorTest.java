package nextstep.ladder.domain.rdd;

import nextstep.ladder.interfaces.Ladder;
import nextstep.ladder.interfaces.LineCreator;
import org.junit.jupiter.api.Test;

public class GameLadderCreatorTest {
    @Test
    void create() {
        LineCreator lineCreator = new GameLineCreator();
        GameLadderCreator gameLadderCreator = new GameLadderCreator(lineCreator);
        Ladder ladder = gameLadderCreator.create(3, 3);
    }
}
