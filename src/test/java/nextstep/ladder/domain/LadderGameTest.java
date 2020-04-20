package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class LadderGameTest {
    @Test
    void generateResultsForAllPlayers() {
        GameInfo gameInfo = new GameInfo(UsersTest.USERS, ResultsTest.RESULTS);
        List<LadderLine> lineList = Stream.of(LadderLineTest.LINE, LadderLineTest.LINE2)
                                          .collect(Collectors.toList());

        Ladder ladder = new Ladder(lineList);
        LadderGame ladderGame = new LadderGame(gameInfo, ladder);
        UserResults userResults = ladderGame.generateResultsForAllPlayers();
        Map<String, Result> userResultsMap = userResults.getUserResults();

        assertThat(userResultsMap.get("pobi").getResult()).isEqualTo("꽝");
        assertThat(userResultsMap.get("honux").getResult()).isEqualTo("꽝");
        assertThat(userResultsMap.get("crong").getResult()).isEqualTo("3000");
        assertThat(userResultsMap.get("jk").getResult()).isEqualTo("5000");
    }
}
