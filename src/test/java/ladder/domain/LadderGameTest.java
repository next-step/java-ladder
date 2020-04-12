package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    private LadderPrize ladderPrize;
    private List<Node> node;
    private Players players;
    private Lines lines;

    @BeforeEach
    public void setUp() throws Exception {
        ladderPrize = new LadderPrize(Arrays.asList("꽝", "100"));
        node = new ArrayList<>(Arrays.asList(
                new Node(0, new Way(false, true)),
                new Node(1, new Way(true, false))));
        players = Players.of(Arrays.asList("a", "b"));
        lines = new Lines(Arrays.asList(new Line(node), new Line(node)));

    }

    @DisplayName("로또 게임 생성자 테스트")
    @Test
    public void constructor_success() throws Exception {
        //given
        Ladder ladder = new Ladder(lines, ladderPrize);

        //when
        LadderGame game = new LadderGame(players, ladder);
    }

    @DisplayName("상품 이름을 찾고 반환한다.")
    @Test
    public void findPrize_success() throws Exception {
        //given
        Ladder ladder = new Ladder(lines, ladderPrize);
        LadderGame game = new LadderGame(players, ladder);

        //when
        String prize = game.findPrize(0);

        //then
        assertThat(prize).isEqualTo("꽝");
    }

    @DisplayName("참가자의 사다리타기 결과를 반환한다")
    @Test
    public void getResult_success() throws Exception {
        //given
        Ladder ladder = new Ladder(lines, ladderPrize);
        LadderGame game = new LadderGame(players, ladder);

        //when
        Map<String, String> result = game.getResult("a");

        //then
        assertThat(result.keySet()).contains("a");
        assertThat(result.get("a")).isEqualTo("꽝");
    }
}
