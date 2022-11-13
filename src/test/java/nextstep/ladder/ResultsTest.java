package nextstep.ladder;

import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Results;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ResultsTest {

    @Test
    void 참여자수와_맞지_않은_경우() {
        Players players = new Players(new String[]{"A", "B", "C", "D"});

        assertThatIllegalArgumentException().isThrownBy(
                () -> new Results(new String[]{"a", "b"}, players.size())
        );
    }
}
