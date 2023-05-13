package ladder.domain;

import ladder.domain.LadderRow;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderRowTest {

    LadderRow ladderRow = new LadderRow(
            new Boolean[]{
                    true, false, true, false
            }
    );

    @Test
    void print() {
        assertThat(ladderRow.toString())
                .isEqualTo("|-----|     |-----|     |");
    }

    @Test
    void size() {
        assertThat(ladderRow.size()).isEqualTo(4);
    }

    @Test
    @DisplayName("AlwaysConnectStrategy 전략은 모든 사다리를 잇는다.")
    void constructor_with_always_strategy() {
        LadderRow ladderRowWithAlwaysConnect = new LadderRow(4, AlwaysConnectStrategy.getInstance());
        assertThat(ladderRowWithAlwaysConnect.toString())
                .isEqualTo("|-----|-----|-----|-----|");
    }
}
