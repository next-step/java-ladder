package nextstep.ladder.domain.edge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderResultTest {

    @DisplayName("LadderResult 인스턴스 만들기")
    @Test
    public void testConstructor() {
        LadderUsers ladderUsers = new LadderUsers(List.of(
            new LadderUser("pobi", 0),
            new LadderUser("honux", 1)
        ));
        LadderPrizes ladderPrizes = new LadderPrizes(List.of(
            new LadderPrize("꽝"),
            new LadderPrize("5000")
        ));

        assertDoesNotThrow(() -> new LadderResult(ladderUsers, ladderPrizes));
    }

    @DisplayName("LadderResult 인스턴스 만들기 - 유저와 결과가 다르면 에러 발생")
    @Test
    public void testConstructor_throwException() {
        LadderUsers ladderUsers = new LadderUsers(List.of(
            new LadderUser("pobi", 0),
            new LadderUser("honux", 1)
        ));
        LadderPrizes ladderPrizes = new LadderPrizes(List.of(new LadderPrize("꽝")));

        assertThatThrownBy(() -> new LadderResult(ladderUsers, ladderPrizes))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("유저와 결과 수가 같지 않습니다.");
    }
}
