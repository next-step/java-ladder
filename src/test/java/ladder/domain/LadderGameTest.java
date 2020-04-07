package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

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

    @DisplayName("사다리 게임 생성")
    @Test
    public void createLadder_success() throws Exception {
        //given
        Players players =
                new Players(Arrays.asList(new Player("a"), new Player("b")));

        //when
        LadderGame game = LadderGame.of(players, 3);

        //then
        assertThat(game.getLines().getLines().size()).isEqualTo(3);
    }
}
