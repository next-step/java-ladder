package nextstep.step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderGameTest {

    @Test
    void 게임결과를_올바르게_생성한다() {
        String names = "pobi,honux,crong,jk";
        String resultInput = "꽝,5000,꽝,3000";
        int ladderHeight = 5;

        Entries entries = new Entries(names);
        Results results = new Results(resultInput);
        Ladder ladder = new Ladder(ladderHeight, entries.getParticipantList().size(), new AlwaysTruePointGenerator());

        LadderGame ladderGame = new LadderGame(ladder);
        GameResult gameResult = ladderGame.gameStart(entries, results);

        assertAll(
                () -> assertEquals("5000", gameResult.getResult("pobi")),
                () -> assertEquals("꽝", gameResult.getResult("honux")),
                () -> assertEquals("3000", gameResult.getResult("crong")),
                () -> assertEquals("꽝", gameResult.getResult("jk"))
        );
    }

    @Test
    void 참가자_수와_당첨_수가_같지_않은채로_게임이_시작하면_에러를_생성시킨다() {

        String names = "pobi,honux,crong,jk";
        String resultInput = "꽝,5000,꽝";
        int ladderHeight = 5;

        Entries entries = new Entries(names);
        Results results = new Results(resultInput);
        Ladder ladder = new Ladder(ladderHeight, entries.getParticipantList().size(), new AlwaysTruePointGenerator());

        LadderGame ladderGame = new LadderGame(ladder);

        Assertions.assertThrows(IllegalArgumentException.class, () -> ladderGame.gameStart(entries, results));
    }
}
