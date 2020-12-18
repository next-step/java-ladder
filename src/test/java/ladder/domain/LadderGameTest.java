package ladder.domain;

import ladder.view.LadderGameView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {


    @Test
    @DisplayName("사다리가 모두 생성될 경우의 최종 결과를 반환한다.")
    void should_return_ladder_game_result_when_is_true() {
        //Given
        LadderGameInformation ladderGameInformation = new LadderGameInformation("pobi,honux,crong,jk", "꽝,5000,꽝,3000");
        LadderSize ladderSize = new LadderSize(4, 5);
        Ladder ladder = new Ladder(ladderSize);

        //When
        LadderGame ladderGame = new LadderGame(ladderGameInformation, ladder);
        LadderResult ladderResult = new LadderResult(ladder.run());
        LadderGameResult result = ladderGame.getLadderGameResult(ladderResult);

        //Then
        Map<String, String> expectedResults = new HashMap<>();
        expectedResults.put("crong", "3000");
        expectedResults.put("jk", "꽝");
        expectedResults.put("pobi", "5000");
        expectedResults.put("honux", "꽝");

        assertThat(result.getResults()).isEqualTo(expectedResults);

    }

    @Test
    @DisplayName("사다리가 모두 생성되지 않을 경우 최종 결과를 반환한다.")
    void should_return_ladder_game_result() {
        //Given
        LadderGameInformation ladderGameInformation = new LadderGameInformation("pobi,honux,crong,jk", "5000,꽝,꽝,3000");
        LadderSize ladderSize = new LadderSize(4, 5);
        Ladder ladder = new Ladder(ladderSize);

        //When
        LadderGame ladderGame = new LadderGame(ladderGameInformation, ladder);
        LadderResult ladderResult = new LadderResult(ladder.run());
        LadderGameResult result = ladderGame.getLadderGameResult(ladderResult);

        //Then
        LadderGameView.printLadders(ladderGameInformation, result);
        Map<String, String> expectedResults = new HashMap<>();
        expectedResults.put("pobi", "5000");
        expectedResults.put("honux", "꽝");
        expectedResults.put("crong", "꽝");
        expectedResults.put("jk", "3000");

        assertThat(result.getResults()).isEqualTo(expectedResults);

    }

    @Test
    @DisplayName("입력받은 이름의 게임 결과를 반환한다.")
    void should_return_ladder_game_result_by_name() {

    }

    @Test
    @DisplayName("입력받은 이름이 참가자명단에 없을 경우 exception을 throw한다.")
    void should_throw_exception_when_not_exists_name() {

    }
}
