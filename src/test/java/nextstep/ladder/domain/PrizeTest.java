package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Test;

class PrizeTest {

    @Test
    void createTest() {
        List<Player> players = List.of(new Player("pobi"));
        List<LadderResult> ladderResults = List.of(new LadderResult("꽝"));

        Prize prize = new Prize(players, ladderResults);

        assertThat(prize).isEqualTo(new Prize(players, ladderResults));
    }

    @Test
    void getPrizeTest() {
        Name pobi = new Name("pobi");
        LadderResult ladderResult = new LadderResult("꽝");
        HashMap<Name, LadderResult> prizeMap = new HashMap<>();
        prizeMap.put(pobi, ladderResult);

        Prize prize = new Prize(List.of(new Player(pobi, new Position(0))), List.of(ladderResult));

        assertThat(prize.getPrize(pobi)).isEqualTo(prizeMap);
    }

    @Test
    void getPrizeAllTest() {
        Name pobi = new Name("pobi");
        LadderResult ladderResult = new LadderResult("꽝");
        HashMap<Name, LadderResult> prizeMap = new HashMap<>();
        prizeMap.put(pobi, ladderResult);

        Prize prize = new Prize(List.of(new Player(pobi, new Position(0))), List.of(ladderResult));

        assertThat(prize.getPrize(new Name("all"))).isEqualTo(prizeMap);
    }

    @Test
    void getPrizeInvalidTest() {
        Name pobi = new Name("pobi");
        LadderResult ladderResult = new LadderResult("꽝");
        HashMap<Name, LadderResult> prizeMap = new HashMap<>();
        prizeMap.put(pobi, ladderResult);

        Prize prize = new Prize(List.of(new Player(pobi, new Position(0))), List.of(ladderResult));

        assertThatThrownBy(() -> prize.getPrize(new Name("crong"))).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid viewer name");
    }
}
