package seungjun.domain.ladder;

import ladder.LadderBody;
import ladder.LadderParticipant;
import ladder.LadderResultItem;
import seungjun.ladder.Names;
import seungjun.ladder.ResultItems;
import seungjun.ladder.SeungjunLadderGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    @DisplayName("[LadderGame.calculateResultOf] 이름 주면 -> 그 이름의 실행 결과 반환")
    public void getResultTest() {
        List<LadderParticipant> names = Names.of("a,b,c,d");
        LadderBody ladder = LadderSampleData.ladder;
        List<LadderResultItem> resultItems = ResultItems.of("some1,some2,some3,some4");

        SeungjunLadderGame ladderGame = new SeungjunLadderGame(names, ladder, resultItems);

        assertThat(ladderGame.calculateResultOf(names.get(0)).resultItem())
                .isEqualTo(resultItems.get(3));
    }
}