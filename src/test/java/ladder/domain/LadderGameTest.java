package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    private LadderPrize ladderPrize;
    private List<Node> node;
    private Players players;

    @BeforeEach
    public void setUp() throws Exception {
        ladderPrize = new LadderPrize(Arrays.asList("꽝", "100"));
        node = new ArrayList<>(Arrays.asList(
                new Node(0, new Way(false, true)),
                new Node(1, new Way(true, false))));
        players = Players.of(Arrays.asList("a", "b"));

    }


    @DisplayName("로또 게임 생성자 테스트")
    @Test
    public void constructor_success() throws Exception {
        //given
        Lines lines = new Lines(Arrays.asList(new Line(node), new Line(node)));
        Ladder ladder = new Ladder(lines, ladderPrize);

        //when
        LadderGame game = new LadderGame(players, ladder);
    }

    @DisplayName("상품 이름을 찾고 반환한다.")
    @Test
    public void findPrize_success() throws Exception {
        //given
        final Lines lines = new Lines(Arrays.asList(new Line(node), new Line(node)));
        Ladder ladder = new Ladder(lines, ladderPrize);

        LadderGame game = new LadderGame(players, ladder);

        //when
        String prize = game.findPrize(0);

        //then
        assertThat(prize).isEqualTo("꽝");
    }
}
