package ladder.controller;

import ladder.controller.dto.LadderGenerationResult;
import ladder.controller.dto.LadderGameResult;
import ladder.controller.dto.LadderGameRequest;
import ladder.controller.dto.LadderGameResponse;
import ladder.domain.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameControllerTest {

    @Test
    @DisplayName("사다리 높이 검증")
    void ladderHeight() {
        // given
        String participantNames = "pobi,honux,crong,jk";
        int ladderHeight = 5;
        LadderGameRequest request = new LadderGameRequest(participantNames, "꽝,5000,꽝,3000", ladderHeight);
        LadderGameController controller = new LadderGameController();

        // when
        LadderGameResponse response = controller.executeLadderGame(request);
        LadderGenerationResult generationResult = response.getLadderGenerationResult();

        // then
        assertThat(ladderHeight).isEqualTo(generationResult.getLadderLines().size());
    }

    @Test
    @DisplayName("사다리 라인 폭 검증")
    void ladderHorizonLength() {
        // given
        String participantNames = "pobi,honux,crong,jk";
        int ladderHeight = 5;
        LadderGameRequest request = new LadderGameRequest(participantNames, "꽝,5000,꽝,3000", ladderHeight);
        LadderGameController controller = new LadderGameController();

        // when
        LadderGameResponse response = controller.executeLadderGame(request);
        LadderGenerationResult generationResult = response.getLadderGenerationResult();

        // then
        assertThat(Ladder.LADDER_HORIZON_WIDTH).isEqualTo(generationResult.getLadderWidth());
    }

    @Test
    @DisplayName("게임실행 결과 검증")
    void ladderGameResult() {
        // given
        String participantNames = "pobi,honux,crong,jk";
        int ladderHeight = 5;
        String gameResults = "꽝,5000,꽝,3000";
        LadderGameRequest request = new LadderGameRequest(participantNames, gameResults, ladderHeight);
        LadderGameController controller = new LadderGameController();

        // when
        LadderGameResponse ladderGameResponse = controller.executeLadderGame(request);

        // then
        for (LadderGameResult gameResult : ladderGameResponse.getLadderGameResults()) {
            assertThat(Arrays.asList(participantNames.split(",")).contains(gameResult.getParticipantName())).isTrue();
            assertThat(Arrays.asList(gameResults.split(",")).contains(gameResult.getMatchingItem())).isTrue();
        }
    }

}