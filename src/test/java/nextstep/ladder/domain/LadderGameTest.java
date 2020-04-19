package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
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
        List<UserResult> userResults = ladderGame.generateResultsForAllPlayers();

        assertThat(userResults.get(0).getResult()).isEqualTo("꽝");
        assertThat(userResults.get(1).getResult()).isEqualTo("꽝");
        assertThat(userResults.get(2).getResult()).isEqualTo("3000");
        assertThat(userResults.get(3).getResult()).isEqualTo("5000");
    }
}
