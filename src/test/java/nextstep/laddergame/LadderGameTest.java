package nextstep.laddergame;

import nextstep.domain.LadderGame;
import nextstep.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameTest {
    private LadderGame ladderGame;

    @BeforeEach
    void setup() {
        ladderGame = new LadderGame("Ben,Joy,tom", 3);

    }

    @Test
    void 사용자_생성_테스트() {
        assertThat(ladderGame.getUser("Ben")).isEqualTo(new User("Ben"));
    }

//    @Test
//    void 사다리_1줄_생성 (){
//        Line ladder = new Line(3);
//        ladder.getPoints().add(Boolean.FALSE);
//        ladder.getPoints().add(Boolean.TRUE);
//        ladder.getPoints().add(Boolean.FALSE);
//        assertThat(ladder.getPoints()).isEqualTo(Arrays.asList(new Boolean(Boolean.FALSE),new Boolean(Boolean.TRUE),
//                new Boolean(Boolean.FALSE)));
//    }


}
