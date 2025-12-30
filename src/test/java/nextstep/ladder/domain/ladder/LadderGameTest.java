package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.strategy.FixedLadderLineGenerateStrategy;
import nextstep.ladder.domain.strategy.RandomLadderLineGenerateStrategy;
import nextstep.ladder.domain.user.User;
import nextstep.ladder.domain.user.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderGameTest {

    private static final Users U1 = new Users("pobi,honux,crong,jk");
    private static Lines L1;
    private static Rewards R1 = new Rewards("꽝,3000,꽝,5000");

    @BeforeEach
    void setup() {
        L1 = new Lines(
                new Line(4, new FixedLadderLineGenerateStrategy(true, false, true)),
                new Line(4, new FixedLadderLineGenerateStrategy(false, true, false)),
                new Line(4, new FixedLadderLineGenerateStrategy(true, false, false)),
                new Line(4, new FixedLadderLineGenerateStrategy(false, false, true))
        );
    }

    @Test
    void 게임_정상_생성() {
        LadderGame ladderGame = new LadderGame(U1, L1, R1);

        assertThat(ladderGame.getUsers().getUsers()).hasSize(4);
        assertThat(ladderGame.getLines().getLines()).hasSize(4);
    }

    @Test
    void 게임_정상_시작() {
        LadderGame ladderGame = new LadderGame(U1, L1, R1);
        LadderResults results = ladderGame.play();

        assertThat(results.getResults().get(0)).isEqualTo(new LadderResult(new User("pobi"), new Reward("5000")));
        assertThat(results.getResults().get(1)).isEqualTo(new LadderResult(new User("honux"), new Reward("3000")));
        assertThat(results.getResults().get(2)).isEqualTo(new LadderResult(new User("crong"), new Reward("꽝")));
        assertThat(results.getResults().get(3)).isEqualTo(new LadderResult(new User("jk"), new Reward("꽝")));

    }

}