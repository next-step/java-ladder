package ladder.domain.ladder.size;

import ladder.exception.ladder.LadderHeightBoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HorizontalLineDirectionHeightTest {

    @Test
    void create() {
        LadderHeight ladderHeight = new LadderHeight(4);

        assertThat(ladderHeight).isEqualTo(new LadderHeight(4));
    }

    @DisplayName("사다리 높이는 1 이상이어야 합니다.")
    @Test
    void valid_height_more_1() {
        assertThatThrownBy(() -> new LadderHeight(0)).isInstanceOf(LadderHeightBoundException.class);
    }
}
