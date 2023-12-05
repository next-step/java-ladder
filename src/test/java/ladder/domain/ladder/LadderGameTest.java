package ladder.domain.ladder;

import ladder.domain.Name;
import ladder.domain.Names;
import ladder.domain.ResultItem;
import ladder.domain.ResultItems;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderGame;
import ladder.domain.ladder.LadderLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    @DisplayName("[LadderGame.calculateResultOf] 이름 주면 -> 그 이름의 실행 결과 반환")
    public void getResultTest() {
        List<Name> names = Names.of("a,b,c,d");
        Ladder ladder = LadderSampleData.ladder;
        List<ResultItem> resultItems = ResultItems.of("some1,some2,some3,some4");

        LadderGame ladderGame = new LadderGame(names, ladder, resultItems);

        assertThat(ladderGame.calculateResultOf(names.get(0)).resultItem())
                .isEqualTo(resultItems.get(3));
    }
}
