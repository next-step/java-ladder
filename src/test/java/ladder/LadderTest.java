package ladder;

import ladder.domain.Ladder;
import ladder.domain.Players;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.domain.Ladder.validateLadderHeight;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class LadderTest {

    @Test
    void 새로운_사다리라인_생성() {
        Ladder ladder = new Ladder(5, new Players(List.of("a","b","c")));
        assertThat(ladder.getLines().size()).isEqualTo(5);
    }

    @Test
    void 양수만_가능() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    validateLadderHeight(-5);
                });
    }
}
