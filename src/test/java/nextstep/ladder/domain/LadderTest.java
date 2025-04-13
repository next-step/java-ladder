package nextstep.ladder.domain;

import nextstep.ladder.domain.edge.LadderPrizes;
import nextstep.ladder.domain.edge.LadderUser;
import nextstep.ladder.domain.edge.LadderUsers;
import nextstep.ladder.domain.edge.Position;
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
        LadderUsers users =  new LadderUsers(ladderUsers);
        LadderPrizes prizes = new LadderPrizes(List.of("꽝", "1000"));
        assertDoesNotThrow(() -> new Ladder(users, prizes, 3));
    }
}
