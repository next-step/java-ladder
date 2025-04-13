package nextstep.ladder.domain;

import nextstep.ladder.domain.edge.LadderEdge;
import nextstep.ladder.domain.result.LadderResults;
import nextstep.ladder.domain.user.LadderUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LadderTest {

    @DisplayName("Ladder 인스턴스 만들기")
    @Test
    public void testConstructor() {
        LadderUsers ladderUsers =  new LadderUsers(List.of("pobi", "honux", "crong", "jk"));
        LadderResults ladderResults = new LadderResults(List.of("꽝", "1000", "꽝", "5000"));
        assertDoesNotThrow(() -> new Ladder(new LadderEdge(ladderUsers, ladderResults), 3));
    }
}
