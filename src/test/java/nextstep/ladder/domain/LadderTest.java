package nextstep.ladder.domain;

import nextstep.ladder.domain.line.Dimension;
import nextstep.ladder.domain.prize.LadderPrize;
import nextstep.ladder.domain.prize.LadderPrizes;
import nextstep.ladder.domain.user.LadderUser;
import nextstep.ladder.domain.user.LadderUsers;
import nextstep.ladder.factory.LineFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LadderTest {

    @DisplayName("Ladder 인스턴스 만들기")
    @Test
    public void testConstructor() {
        LadderUsers ladderUsers = new LadderUsers(
            List.of(new LadderUser("pobi", 0), new LadderUser("honux", 1))
        );
        LadderPrizes ladderPrizes = new LadderPrizes(
            List.of(new LadderPrize("꽝"), new LadderPrize("5000"))
        );

        assertDoesNotThrow(() -> new Ladder(ladderUsers, ladderPrizes, new Dimension(3), new LineFactory()));
    }

    @DisplayName("LadderC 인스턴스 생성 - 유저와 결과 수가 맞지 않으면 예외 반환")
    @Test
    public void testConstructor_throwException() {
        LadderUsers ladderUsers = new LadderUsers(
            List.of(new LadderUser("pobi", 0), new LadderUser("honux", 1))
        );
        LadderPrizes ladderPrizes = new LadderPrizes(List.of(new LadderPrize("1000")));

        assertThatThrownBy(() -> new Ladder(ladderUsers, ladderPrizes, new Dimension(3), new LineFactory()))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("유저와 결과 수가 맞지 않습니다.");
    }
}


