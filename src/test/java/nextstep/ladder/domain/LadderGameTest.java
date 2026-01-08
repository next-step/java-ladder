package nextstep.ladder.domain;

import nextstep.ladder.factory.LineFactory;
import nextstep.ladder.generator.FixedLineGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class LadderGameTest {
    @Test
    void 생성() {
        LineFactory lineFactory = new LineFactory(new FixedLineGenerator(
                true, false, true,   // 1번째 Line
                false, true, false,  // 2번째 Line
                true, false, false   // 3번째 Line
        ));

        Ladder ladder = new Ladder(3, 4, lineFactory);

        LadderGame ladderGame = new LadderGame("pobi,honux,crong,jk", ladder);

        Assertions.assertThat(ladderGame.getPlayers()).hasSize(4);
    }
}
