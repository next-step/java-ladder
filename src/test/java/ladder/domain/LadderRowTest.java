package ladder.domain;

import ladder.domain.LadderRow;
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
}
