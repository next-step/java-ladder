package nextstep.ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ReportTest {

    Report report;
    Players players;
    Results results;

    @BeforeEach
    void setUp() {
        String[] splitNames = "pobi,honux,crong,jk".split(",");
        String[] splitResults = "꽝,5000,꽝,꽝".split(",");

        players = new Players(splitNames);
        results = new Results(splitResults, splitNames.length);
        report = new Report(players, results);
    }

    @Test
    @DisplayName("Report 생성")
    void constructor() {
        Index zeroIndex = new Index();
        Player player = players.findPlayerByIndex(zeroIndex);
        Result result = results.findResultByIndex(zeroIndex);

        assertThat(report.getPlayerResults().get(player)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,0,꽝", "honux,1,5000", "crong,2,꽝", "jk,3,꽝"})
    @DisplayName("이름으로 Result 찾기")
    void findResultByPlayer(String playerName, int index, String resultName) {
        Result result = report.findResultByPlayerName(playerName);

        assertThat(result).isEqualTo(new Result(resultName, new Index(index)));
    }

    @Test
    @DisplayName("이름으로 Result 찾기: 실패")
    void failFindResultByPlayer() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> report.findResultByPlayerName("test"));
    }
}