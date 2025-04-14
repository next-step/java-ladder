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
        List<Result> results = List.of(new Result("꽝"));

        Prize prize = new Prize(players, results);

        assertThat(prize).isEqualTo(new Prize(players, results));
    }

    @Test
    void getPrizeTest() {
        Name pobi = new Name("pobi");
        Result result = new Result("꽝");
        HashMap<Name, Result> prizeMap = new HashMap<>();
        prizeMap.put(pobi, result);

        Prize prize = new Prize(List.of(new Player(pobi, new Position(0))), List.of(result));

        assertThat(prize.getPrize(pobi)).isEqualTo(prizeMap);
    }

    @Test
    void getPrizeAllTest() {
        Name pobi = new Name("pobi");
        Result result = new Result("꽝");
        HashMap<Name, Result> prizeMap = new HashMap<>();
        prizeMap.put(pobi, result);

        Prize prize = new Prize(List.of(new Player(pobi, new Position(0))), List.of(result));

        assertThat(prize.getPrize(new Name("all"))).isEqualTo(prizeMap);
    }

    @Test
    void getPrizeInvalidTest() {
        Name pobi = new Name("pobi");
        Result result = new Result("꽝");
        HashMap<Name, Result> prizeMap = new HashMap<>();
        prizeMap.put(pobi, result);

        Prize prize = new Prize(List.of(new Player(pobi, new Position(0))), List.of(result));

        assertThatThrownBy(() -> prize.getPrize(new Name("crong"))).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid viewer name");
    }
}
