package ladder;

import ladder.domain.LadderGameResult;
import ladder.domain.Player;
import ladder.domain.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LadderGameResultTest {

    private LadderGameResult ladderGameResult;

    private static final Player PLAYER1 = new Player("참가자1");
    private static final Player PLAYER2 = new Player("참가자2");
    private static final Player PLAYER3 = new Player("참가자3");

    private static final Prize PRIZE1 = new Prize("꽝");
    private static final Prize PRIZE2 = new Prize("5000");
    private static final Prize PRIZE3 = new Prize("3000");

    @BeforeEach
    public void setUp() {
        Map<Player, Prize> gameResultMap = Map.of(
                PLAYER1, PRIZE1,
                PLAYER2, PRIZE2,
                PLAYER3, PRIZE3
        );

        ladderGameResult = new LadderGameResult(gameResultMap);
    }

    @Test
    public void 참가자의_이름을_입력하면_결과를_반환한다() {
        assertThat(ladderGameResult.findPrizeByPlayerName("참가자1")).isEqualTo(new Prize("꽝"));
        assertThat(ladderGameResult.findPrizeByPlayerName("참가자2")).isEqualTo(new Prize("5000"));
        assertThat(ladderGameResult.findPrizeByPlayerName("참가자3")).isEqualTo(new Prize("3000"));
    }

    @Test
    public void 없는_참가자의_이름을_입력하면_예외가_발생한다() {
        String invalidUserName = "홍길동";
        assertThatIllegalArgumentException().isThrownBy(() -> ladderGameResult.findPrizeByPlayerName(invalidUserName));
    }

}
