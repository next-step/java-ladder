package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertSame;

@DisplayName("사다리 게임 구성요소 테스트")
public class LadderGameComponentsTest {

    @DisplayName("플레이어 수, 사다리 참가자 수, 사다리 결과 개수가 맞지 않으면 예외가 발생한다.")
    @Test
    void countMismatchBetweenPlayersAndLadderPlayersAndLadderResultsExceptionTest() {
        // given
        Players twoPlayers = new Players(Arrays.asList("aiden", "pobi"));
        Players threePlayers = new Players(Arrays.asList("aiden", "pobi", "crong"));

        Ladder twoPlayerLadder = new Ladder(2, 3);
        Ladder threePlayerLadder = new Ladder(3, 3);

        LadderResults twoResults = new LadderResults(Arrays.asList("1000", "2000"));
        LadderResults threeResults = new LadderResults(Arrays.asList("1000", "2000", "3000"));
        LadderResults fourResults = new LadderResults(Arrays.asList("1000", "2000", "3000", "4000"));

        // when, then
        String exceptionMessage = "플레이어 수, 사다리 참가자 수, 사다리 결과의 개수가 일치하지 않습니다.";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGameComponents(twoPlayers, threePlayerLadder, twoResults))
                .withMessage(exceptionMessage);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGameComponents(twoPlayers, twoPlayerLadder, threeResults))
                .withMessage(exceptionMessage);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGameComponents(threePlayers, twoPlayerLadder, twoResults))
                .withMessage(exceptionMessage);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGameComponents(twoPlayers, threePlayerLadder, fourResults))
                .withMessage(exceptionMessage);
    }

    @DisplayName("플레이어 수, 사다리 참가자 수, 사다리 결과 개수가 일치하면 그 수에 맞게 정상 생성되어야 한다.")
    @Test
    void createLadderGameComponentsTest() {
        // given
        Players players = new Players(Arrays.asList("aiden", "pobi", "crong"));
        Ladder ladder = new Ladder(3, 3);
        LadderResults results = new LadderResults(Arrays.asList("1000", "2000", "3000"));
        LadderGameComponents ladderGameComponents = new LadderGameComponents(players, ladder, results);

        // when, then
        assertSame(ladderGameComponents.playerCount(), 3);
    }
}
