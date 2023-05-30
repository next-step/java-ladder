package ladder;

import ladder.domain.Players;
import ladder.domain.Results;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ResultsTest {
    @Test
    void 결과값_개수는_플레이어수와_동일해야_함() {
        Players players = new Players(List.of("1번", "2번"));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new Results(List.of("꽝"), players);
                });
    }
}
