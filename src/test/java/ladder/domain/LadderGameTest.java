package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class LadderGameTest {

    private static List<HorizontalLine> newHorizontalLines() {
        List<HorizontalLine> horizontalLines = new ArrayList<>();
        horizontalLines.add(new HorizontalLine(true, false));
        horizontalLines.add(new HorizontalLine(false, true));
        return horizontalLines;
    }

    @Test
    void 사다리_게임_결과() {
        Members members = new Members("aaaa", "bbb", "cc");
        Ladder ladder = new Ladder(newHorizontalLines());
        String[] inputResults = new String[]{"꽝", "5000", "꽝"};
        String[] memberNames = {"aaaa", "bbb", "ccc"};
        GameResults gameResults = new GameResults(inputResults, memberNames);
        String ladderClimber = "all";

        LadderGame ladderGame = new LadderGame(members, ladder, gameResults, ladderClimber);
        String resultOfGame = ladderGame.start().toString();
        assertThat(resultOfGame).isEqualTo("{aaaa=꽝, bbb=꽝, cc=5000}");
    }
}
