package ladder.ladder;

import ladder.model.ladder.LadderItem;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderItemTest {
    @Test
    public void 정상_아이템() {
        assertThat(LadderItem.findItem(0)).isEqualTo(LadderItem.BLANK_HORIZONTAL);
        assertThat(LadderItem.findItem(1)).isEqualTo(LadderItem.HORIZONTAL);
        assertThat(LadderItem.findItem(2)).isEqualTo(LadderItem.VERTICAL);
    }
}
