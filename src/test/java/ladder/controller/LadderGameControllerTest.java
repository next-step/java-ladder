package ladder.controller;

import ladder.controller.dto.LadderGameRequest;
import ladder.controller.dto.LadderGameResponse;
import ladder.controller.dto.LadderGameTotalResultResponse;
import ladder.controller.dto.LadderLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderGameControllerTest {

    @ParameterizedTest
    @CsvSource(value = {"pobi:꽝", "honux:3000", "crong:꽝", "jk:5000"}, delimiter = ':')
    @DisplayName("사다리게임 결과 조회 - 단건조회")
    void inquiryGameResult(String inquiryName, String expectedResult) {
        // given
        LadderGameController controller = new LadderGameController();

        List<String> participants = Arrays.asList("pobi", "honux", "crong", "jk");
        List<LadderLine> ladderLines = new ArrayList<>();
        ladderLines.add(new LadderLine(Arrays.asList(true, false, true, false)));
        ladderLines.add(new LadderLine(Arrays.asList(false, true, false, false)));
        ladderLines.add(new LadderLine(Arrays.asList(true, false, false, false)));
        ladderLines.add(new LadderLine(Arrays.asList(false, true, false, false)));
        ladderLines.add(new LadderLine(Arrays.asList(true, false, true, false)));
        List<String> gameResults = Arrays.asList("꽝", "5000", "꽝", "3000");
        LadderGameRequest request = new LadderGameRequest(participants, ladderLines, gameResults, inquiryName);

        // when
        LadderGameResponse response = controller.inquiryGameResult(request);

        // then
        assertThat(expectedResult).isEqualTo(response.getGameResult());
    }

    @Test
    @DisplayName("사다리게임 결과 리스트 조회")
    void inquiryGameResults() {
        // given
        List<String> expectedList = Arrays.asList("꽝", "3000", "꽝", "5000");

        LadderGameController controller = new LadderGameController();

        List<String> participants = Arrays.asList("pobi", "honux", "crong", "jk");
        List<LadderLine> ladderLines = new ArrayList<>();
        ladderLines.add(new LadderLine(Arrays.asList(true, false, true, false)));
        ladderLines.add(new LadderLine(Arrays.asList(false, true, false, false)));
        ladderLines.add(new LadderLine(Arrays.asList(true, false, false, false)));
        ladderLines.add(new LadderLine(Arrays.asList(false, true, false, false)));
        ladderLines.add(new LadderLine(Arrays.asList(true, false, true, false)));
        List<String> gameResults = Arrays.asList("꽝", "5000", "꽝", "3000");
        LadderGameRequest request = new LadderGameRequest(participants, ladderLines, gameResults, "all");

        // when
        LadderGameTotalResultResponse response = controller.inquiryGameResults(request);

        // then
        assertAll(
                () -> {
                    for (int i = 0; i < participants.size(); i++) {
                        assertThat(participants.get(i)).isEqualTo(response.getParticipantNames().get(i));
                    }
                },
                () -> {
                    for (int i = 0; i < expectedList.size(); i++) {
                        assertThat(expectedList.get(i)).isEqualTo(response.getGameResults().get(i));
                    }
                }
        );
    }
}