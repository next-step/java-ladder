package ladder;

import ladder.model.LadderItem;
import ladder.model.Line;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {
    @Test
    public void 비정상_사다리() {
        List<LadderItem> case1 = Arrays.asList(LadderItem.HORIZONTAL, LadderItem.HORIZONTAL);
        List<LadderItem> case2 = Arrays.asList(LadderItem.BLANK_HORIZONTAL, LadderItem.HORIZONTAL, LadderItem.HORIZONTAL);
        List<LadderItem> case3 = Arrays.asList(LadderItem.HORIZONTAL, LadderItem.HORIZONTAL, LadderItem.BLANK_HORIZONTAL);

        assertThatThrownBy(() -> Line.from(case1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Line.from(case2)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Line.from(case3)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 정상_사다리() {
        Line case1 = Line.from(Arrays.asList(LadderItem.HORIZONTAL, LadderItem.BLANK_HORIZONTAL));
        Line case2 = Line.from(Arrays.asList(LadderItem.BLANK_HORIZONTAL, LadderItem.HORIZONTAL));
        Line case3 = Line.from(Arrays.asList(LadderItem.BLANK_HORIZONTAL, LadderItem.BLANK_HORIZONTAL));

        assertThat(case1);
        assertThat(case2);
        assertThat(case3);
    }
}
