package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultsTest {

    @DisplayName("사다리 게임 결과를 알 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"pobi,5000", "crong,3000", "jk,꽝","honux,꽝"}, delimiter = ',')
    void processLadderGameOutcomesTest(String playName, String outcome) {
        Players players = Players.of(List.of("pobi", "honux", "crong", "jk"));
        Ladder ladder = Ladder.of(
                List.of(
                        Line.of(List.of(true, false, false)),
                        Line.of(List.of(false, false, true)),
                        Line.of(List.of(false, false, false)),
                        Line.of(List.of(false, true, false)),
                        Line.of(List.of(false, true, false))
                ));
        LadderResults ladderResults = LadderResults.of(List.of("꽝", "5000", "꽝", "3000"));
        ladderResults.processLadderGameOutcomes(players, ladder);
        Map<String, String> ladderGameOutcomes = ladderResults.ladderGameOutcomes();

        assertThat(ladderGameOutcomes.get(playName)).isEqualTo(outcome);
    }
}