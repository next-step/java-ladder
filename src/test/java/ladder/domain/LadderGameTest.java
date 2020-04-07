package ladder.domain;

import ladder.exception.LadderException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderGameTest {

    private LadderPrize gameResult = new LadderPrize(Arrays.asList("꽝", "100"));

    @DisplayName("로또 게임 생성자 테스트")
    @Test
    public void constructor_success() throws Exception {
        //given
        Players players =
                new Players(Arrays.asList(new Player("a"), new Player("b")));
        Lines lines = new Lines(Arrays.asList(new Line(), new Line(), new Line()));

        //when
        LadderGame game = new LadderGame(players, lines, gameResult);
    }

    @DisplayName("참가자와 게임 결과의 수가 일치해야 한다.")
    @Test
    public void constructor_fail() throws Exception {
        //given
        Players players = Players.of(Arrays.asList("a", "b", "c"));
        Lines lines = new Lines();
        LadderPrize gameResult = new LadderPrize(Arrays.asList("5000", "꽝"));

        //then
        assertThatThrownBy(
                () -> new LadderGame(players, lines, gameResult)
        ).isInstanceOf(LadderException.class);
    }

    @DisplayName("사다리 게임 생성")
    @Test
    public void createLadder_success() throws Exception {
        //given
        Players players =
                new Players(Arrays.asList(new Player("a"), new Player("b")));

        //when
        LadderGame game = LadderGame.of(players, 3, gameResult);

        //then
        assertThat(game.getLines().getLines().size()).isEqualTo(3);
    }

    @DisplayName("참가자의 이름을 전달 받고 사다리 진행 결과 Node 반환")
    @Test
    public void getPlayerResult_success() throws Exception {
        //given
        final String playerName = "a";
        final Players players = Players.of(Arrays.asList("a", "b"));
        final Lines lines = new Lines(
                Arrays.asList(
                        new Line(Arrays.asList(
                                new Node(0, new Way(false, true)),
                                new Node(1, new Way(true, false)))
                        ),
                        new Line(Arrays.asList(
                                new Node(0, new Way(false, true)),
                                new Node(1, new Way(true, false)))
                        )));
        LadderGame game = new LadderGame(players, lines, gameResult);

        //when
        Node result = game.findPlayerResult(playerName);

        //then
        assertThat(result.getIndex()).isEqualTo(0);
    }
}
