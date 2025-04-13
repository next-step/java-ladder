package nextstep.ladder.domain;

import nextstep.ladder.domain.edge.*;
import nextstep.ladder.domain.line.Height;
import nextstep.ladder.domain.line.LineFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LadderTest {

    @DisplayName("Ladder 인스턴스 만들기")
    @Test
    public void testConstructor() {
        List<LadderUser> ladderUsers = List.of(
            new LadderUser("pobi", new Position(0)),
            new LadderUser("honux", new Position(1))
        );
        List<LadderPrize> ladderPrizes = List.of(
            new LadderPrize("꽝"),
            new LadderPrize("5000")
        );

        LadderUsers users =  new LadderUsers(ladderUsers);
        LadderPrizes prizes = new LadderPrizes(ladderPrizes);
        assertDoesNotThrow(() -> new Ladder(new LadderConfig(users, prizes), new Height(3), new LineFactory()));
    }
}
