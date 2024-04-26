package nextstep.ladder.domain.rdd;

import nextstep.ladder.interfaces.Line;
import org.junit.jupiter.api.Test;

public class GameLineCreatorTest {
    @Test
    void create() {
        GameLineCreator gameLineCreator = new GameLineCreator();

        Line line = gameLineCreator.create(3);
    }
}
