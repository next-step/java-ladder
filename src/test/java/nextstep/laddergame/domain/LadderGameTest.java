package nextstep.laddergame.domain;

import static nextstep.laddergame.builder.LadderBuilder.aLadderBuilder;
import static nextstep.laddergame.builder.LadderBuilder.aLadderResult;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;

class LadderGameTest {

    @Test
    void 사다리게임의_결과가_리턴된다() {
        LadderGame ladderGame = new LadderGame(
            new Participants("mo,jae,young"),
            aLadderBuilder()
        );
        List<LadderResult> ladderResults = ladderGame.ladderGameResult();
        List<LadderResult> expectedResults = List.of(
            new LadderResult("mo", aLadderResult(2)),
            new LadderResult("jae", aLadderResult(1)),
            new LadderResult("young", aLadderResult(0))
        );

        assertThat(ladderResults).isEqualTo(expectedResults);
    }
}