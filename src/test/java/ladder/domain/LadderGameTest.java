package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    private LadderPrize ladderPrize;
    private Players players;
    private Lines lines;

    @BeforeEach
    public void setUp() throws Exception {
        ladderPrize = new LadderPrize(Arrays.asList("꽝", "100"));
        players = Players.of(Arrays.asList("a", "b"));
        lines = Lines.of(2, 2, WayTest.strategyTrue);
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

    @DisplayName("모든 참가자의 사다리타기 결과를 반환한다")
    @Test
    public void getResultAll_success() throws Exception {
        //given
        Ladder ladder = new Ladder(lines, ladderPrize);
        LadderGame game = new LadderGame(players, ladder);

        //when
        Map<String, String> result = game.getResultAll();

        //then
        assertThat(result.keySet()).contains("a");
        assertThat(result.keySet()).contains("b");
        assertThat(result.get("a")).isEqualTo("꽝");
        assertThat(result.get("b")).isEqualTo("100");
    }
}
