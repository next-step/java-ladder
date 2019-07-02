package nextstep.laddergame;

import nextstep.domain.LadderGame;
import nextstep.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    private LadderGame ladderGame;

    @BeforeEach
    void setup(){
        ladderGame = new LadderGame("Ben,Joy,tom",5);
    }

    @Test
    void 사용자_생성_테스트(){
        assertThat(ladderGame.getUser("Ben")).isEqualTo(new User("Ben"));
    }
}
