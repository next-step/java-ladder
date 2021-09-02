package ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import static ladder.model.LadderLineGeneratorTest.generatePointsMethod;
import static ladder.model.LadderLineGeneratorTest.ladderLinesGenerator;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@DisplayName("사다리 게임 구성요소 테스트")
public class LadderGameTest {

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

        // when, then
        String exceptionMessage = "플레이어 수, 사다리 참가자 수, 사다리 결과의 개수가 일치하지 않습니다.";

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGame(twoPlayers, threePlayerLadder, twoResults))
                .withMessage(exceptionMessage);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGame(twoPlayers, twoPlayerLadder, threeResults))
                .withMessage(exceptionMessage);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LadderGame(threePlayers, twoPlayerLadder, twoResults))
                .withMessage(exceptionMessage);
    }

    @DisplayName("플레이어 수, 사다리 참가자 수, 사다리 결과 개수가 일치하면 그 수에 맞게 정상 생성되어야 한다.")
    @Test
    void createLadderGameTest() {
        // given
        Players players = new Players(Arrays.asList("aiden", "pobi", "crong"));
        Ladder ladder = new Ladder(3, 3);
        LadderResults results = new LadderResults(Arrays.asList("1000", "2000", "3000"));
        LadderGame ladderGame = new LadderGame(players, ladder, results);

        // when, then
        assertSame(ladderGame.playerCount(), 3);
    }

    @DisplayName("플레이어의 사다리 실행 결과가 정상적으로 찾아져야 한다.")
    @Test
    void findLadderResultOfPlayerTest() throws InvocationTargetException, IllegalAccessException {
        // given
        Players players = new Players(Arrays.asList("aiden", "pobi", "crong"));

        LadderLine firstLine = new LadderLine((List<LadderPoint>) generatePointsMethod.invoke(ladderLinesGenerator, Arrays.asList(true, false)));
        LadderLine secondLine = new LadderLine((List<LadderPoint>) generatePointsMethod.invoke(ladderLinesGenerator, Arrays.asList(false, true)));
        LadderLine thirdLine = new LadderLine((List<LadderPoint>) generatePointsMethod.invoke(ladderLinesGenerator, Arrays.asList(true, false)));
        Ladder ladder = new Ladder(Arrays.asList(firstLine, secondLine, thirdLine));

        LadderResults results = new LadderResults(Arrays.asList("1000", "2000", "3000"));

        LadderGame ladderGame = new LadderGame(players, ladder, results);

        // when, then
        assertEquals(ladderGame.findResult("aiden"), "3000");
        assertEquals(ladderGame.findResult("pobi"), "2000");
        assertEquals(ladderGame.findResult("crong"), "1000");
    }
}
