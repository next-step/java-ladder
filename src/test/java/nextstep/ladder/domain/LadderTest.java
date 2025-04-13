package nextstep.ladder.domain;

import nextstep.ladder.domain.edge.LadderPrizes;
import nextstep.ladder.domain.edge.LadderUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LadderTest {

    @DisplayName("Ladder 인스턴스 만들기")
    @Test
    public void testConstructor() {
        LadderUsers users =  new LadderUsers(List.of("pobi", "honux", "crong", "jk"));
        LadderPrizes prizes = new LadderPrizes(List.of("꽝", "1000", "꽝", "5000"));
        assertDoesNotThrow(() -> new Ladder(users, prizes, 3));
    }
}
