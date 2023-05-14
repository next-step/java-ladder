package ladder.domain;

import ladder.domain.Ladder;
import ladder.domain.LadderRow;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LadderTest {
    @Test
    void create() {
        assertAll(
                () -> {
                    assertThatThrownBy(() -> new Ladder(-1, 0))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("음수는 입력할 수 없습니다.");
                },
                () -> {
                    assertDoesNotThrow(() -> new Ladder(4, 3));
                }
        );

    }

    @Test
    void print() {
        LadderRow[] ladderRows = new LadderRow[]{
                new LadderRow(new Boolean[]{true, false, true, false}),
                new LadderRow(new Boolean[]{false, true, false, true}),
                new LadderRow(new Boolean[]{true, false, true, false}),
                new LadderRow(new Boolean[]{false, true, false, true})
        };

        Ladder ladder = new Ladder(ladderRows);
        assertThat(ladder.toString()).isEqualTo(
                "|-----|     |-----|     |\n" +
                        "|     |-----|     |-----|\n" +
                        "|-----|     |-----|     |\n" +
                        "|     |-----|     |-----|\n"
        );
    }
}
