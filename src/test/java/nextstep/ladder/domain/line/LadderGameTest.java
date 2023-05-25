package nextstep.ladder.domain.line;

import nextstep.ladder.domain.user.User;
import nextstep.ladder.domain.user.Users;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderGameTest {

    @Test
    public void 사다리타기_게임시작() {
        //given
        Users users = new Users("A,B,C");
        LadderHeight ladderHeight = new LadderHeight(2);
        Ladder ladder = new Ladder(new TestLineGenerator(), ladderHeight, users);
        LadderGame ladderGame = new LadderGame(ladder, users);

        //when
        ladderGame.start();

        //then
        LadderResult ladderResult = ladderGame.toResult();
        assertThat(ladderResult.get(new User("A"))).isEqualTo(0);
        assertThat(ladderResult.get(new User("B"))).isEqualTo(1);
        assertThat(ladderResult.get(new User("C"))).isEqualTo(2);
    }

}
