package nextstep.ladder.domain;

import nextstep.ladder.factory.LineFactory;
import nextstep.ladder.generator.FixedLineGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {

    @Test
    void 생성() {
        LineFactory lineFactory = new LineFactory(new FixedLineGenerator(
                true, false, true,   // 1번째 Line
                false, true, false,  // 2번째 Line
                true, false, false   // 3번째 Line
        ));

        Ladder ladder = new Ladder(3, 4, lineFactory);

        LadderGame ladderGame = new LadderGame("pobi,honux,crong,jk", ladder, "꽝,5000,꽝,3000");

        assertThat(ladderGame.getPlayers()).hasSize(4);
    }

    @Test
    void 특정_플레이어의_결과를_반환한다() {
        LineFactory factory = new LineFactory(new FixedLineGenerator(
                true, false, true,
                false, true, false,
                true, false, false
        ));
        Ladder ladder = new Ladder(3, 4, factory);

        LadderGame game = new LadderGame(
                "pobi,honux,crong,jk",
                ladder,
                "꽝,5000,꽝,3000"
        );

        assertThat(game.play("honux").getValue()).isEqualTo("5000");
        assertThat(game.play("jk").getValue()).isEqualTo("꽝");
    }
}
