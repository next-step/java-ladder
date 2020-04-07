package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    private LadderPrize gameResult = new LadderPrize(Arrays.asList("꽝", "100"));

    @DisplayName("로또 게임 생성자 테스트")
    @Test
    public void constructor_success() throws Exception {
        //given
        Players players =
                new Players(Arrays.asList(new Player("a"), new Player("b")));
        Lines lines = new Lines(Arrays.asList(new Line(), new Line()));
        Ladder ladder = new Ladder(lines, new LadderPrize(Arrays.asList("1", "2")));

        //when
        LadderGame game = new LadderGame(players, ladder);
    }

    @DisplayName("상품 이름을 찾고 반환한다.")
    @Test
    public void findPrize_success() throws Exception {
        //given
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
        final LadderPrize ladderPrize = new LadderPrize(Arrays.asList("100", "200"));
        Ladder ladder = new Ladder(lines, ladderPrize);

        LadderGame game = new LadderGame(players, ladder);

        //when
        String prize = game.findPrize(0);

        //then
        assertThat(prize).isEqualTo("100");
    }
}
