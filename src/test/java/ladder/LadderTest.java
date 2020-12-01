package ladder;

import ladder.model.Ladder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {
    @Test
    public void 음수_높이_사다리() {
        assertThatThrownBy(() -> new Ladder("-1", 2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 높이가_없는_사다리() {
        assertThatThrownBy(() -> new Ladder("0", 2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 정상_사다리() {
        Ladder ladder = new Ladder("1", 2);
        assertThat(ladder.getLadder().size()).isEqualTo(1);
    }
}
