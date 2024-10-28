package ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderCountTest {

    @Test
    public void create() {
        LadderCount ladderCount = new LadderCount("1");
        assertThat(ladderCount).isEqualTo(new LadderCount("1"));
    }

    @Test
    public void valid() {
        assertThatThrownBy(() -> {
            LadderCount ladderCount = new LadderCount("0");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
