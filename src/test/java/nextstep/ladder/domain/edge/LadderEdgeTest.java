package nextstep.ladder.domain.edge;

import nextstep.ladder.domain.result.LadderResults;
import nextstep.ladder.domain.user.LadderUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderEdgeTest {

    @DisplayName("LadderEdge 인스턴스 생성")
    @Test
    public void testConstructor() {
        LadderUsers ladderUsers =  new LadderUsers(List.of("pobi", "honux", "crong", "jk"));
        LadderResults ladderResults = new LadderResults(List.of("꽝", "1000", "꽝", "5000"));
        assertDoesNotThrow(() -> new LadderEdge(ladderUsers, ladderResults));
    }

    @DisplayName("LadderEdge 인스턴스 생성 - user수와 결과 수가 맞지 않으면 예외를 반환")
    @Test
    public void testConstructor_throwException() {
        LadderUsers ladderUsers =  new LadderUsers(List.of("pobi", "honux", "crong", "jk"));
        LadderResults ladderResults = new LadderResults(List.of("꽝", "1000", "꽝"));
        assertThatThrownBy(() -> new LadderEdge(ladderUsers, ladderResults))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("유저 수와 결과 수는 같아야 합니다.");
    }
}
