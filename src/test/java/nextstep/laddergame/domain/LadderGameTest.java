package nextstep.laddergame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;

class LadderGameTest {

    @Test
    void 사다리게임의_결과가_리턴된다() {
        LadderGame ladderGame = new LadderGame(
            new Participants("mo,jae,young"),
            new Ladder(
                List.of(
                    new Line(() -> List.of(true, false, false)),
                    new Line(() -> List.of(false, true, false)),
                    new Line(() -> List.of(true, false, false))
                ),
                "꽝", "당첨", "아슬")
        );
        List<LadderResult> ladderResults = ladderGame.ladderGameResult();
        List<LadderResult> expectedResults = List.of(
            new LadderResult("mo", "아슬"),
            new LadderResult("jae", "당첨"),
            new LadderResult("young", "꽝")
        );

        assertThat(ladderResults).isEqualTo(expectedResults);
    }
}