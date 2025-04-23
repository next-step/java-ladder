package nextstep.ladder;

import ladder.Player;
import ladder.Players;
import ladder.Result;
import ladder.Results;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ResultsTest {
    @Test
    void 결과와_players_수_불일치() {
        Players players = new Players(List.of(new Player("1"), new Player("2")));
        List<Result> results = List.of(new Result("1"));
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> new Results(results, players));
    }

    @Test
    void result_5글자이상() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> new Result("dfafasdfdf"));
    }
}

