package nextstep.ladder.domain.laddergame;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.LadderResultTest;
import nextstep.ladder.domain.ladder.LadderTest;
import nextstep.ladder.domain.laddergame.position.Positions;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LadderGameResultTest {

    @Test
    void getResult() {
        Ladder ladder = LadderTest.getLadder();

        List<Positions> positionsList = new ArrayList<>();

        for (int i = 0; i < ladder.getPlayers().size(); i++) {
            Positions positions = new Positions();
            positionsList.add(positions.add(ladder.getLines(), i));
        }

        LadderGameResult ladderGameResult = new LadderGameResult(ladder.getPlayers(), positionsList, LadderResultTest.ladderResult);

        Assertions.assertThat(ladderGameResult.getResult("test1")).isEqualTo("10000원");
        Assertions.assertThat(ladderGameResult.getResult("test2")).isEqualTo("5000원");
        Assertions.assertThat(ladderGameResult.getResult("test3")).isEqualTo("15000원");
        Assertions.assertThat(ladderGameResult.getResult("test4")).isEqualTo("꽝");
    }

    @Test
    void getResultAll() {
        Ladder ladder = LadderTest.getLadder();

        List<Positions> positionsList = new ArrayList<>();

        for (int i = 0; i < ladder.getPlayers().size(); i++) {
            Positions positions = new Positions();
            positionsList.add(positions.add(ladder.getLines(), i));
        }

        LadderGameResult ladderGameResult = new LadderGameResult(ladder.getPlayers(), positionsList, LadderResultTest.ladderResult);

        Assertions.assertThat(ladderGameResult.getResultAll()).isNotNull();
        Assertions.assertThat(ladderGameResult.getResultAll().size()).isEqualTo(4);
        Assertions.assertThat(ladderGameResult.getResultAll().get(0)).isEqualTo("test1 : 10000원");
    }
}