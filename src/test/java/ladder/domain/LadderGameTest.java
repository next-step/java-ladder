package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LadderGameTest {

    @DisplayName("로또 게임 생성자 테스트")
    @Test
    public void constructor_success() throws Exception {
        //given
        Players players =
                new Players(Arrays.asList(new Player("a"), new Player("b")));
        Lines lines = new Lines(Arrays.asList(new Line(), new Line(), new Line()));

        //when
        LadderGame game = new LadderGame(players, lines);
    }
}
