package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.strategy.RandomLadderLineGenerateStrategy;
import nextstep.ladder.domain.user.Users;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderGameTest {

    private static final Users U1 = new Users("pobi,honux,crong,jk");
    private static Lines L1;

    @BeforeEach
    void setup(){
        L1 = new Lines(
                new Line(3, new RandomLadderLineGenerateStrategy()),
                new Line(3, new RandomLadderLineGenerateStrategy()),
                new Line(3, new RandomLadderLineGenerateStrategy()),
                new Line(3, new RandomLadderLineGenerateStrategy())
        );
    }

    @Test
    void 게임_정상_생성(){
        LadderGame ladderGame = new LadderGame(U1, L1);

        assertThat(ladderGame.getUsers().getUsers()).hasSize(4);
        assertThat(ladderGame.getLines().getLines()).hasSize(4);
    }

    @Test
    void 게임_시작(){
        LadderGame ladderGame = new LadderGame(U1, L1);

        LadderResults result = ladderGame.play();
    }

}