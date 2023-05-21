package nextstep.ladder;

import nextstep.ladder.drawPolicy.AllDraw;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderRowTest {

    LadderRow ladderRow;

    @BeforeEach
    void init(){
        ladderRow = new LadderRow(5, new AllDraw());
    }

    @Test
    void drawLadderRow() {
        var acutualLadderRow = ladderRow.drawLadderRow();
        var expectLadderRow = "|-----|     |-----|     |     ";

        assertThat(acutualLadderRow).isEqualTo(expectLadderRow);
    }
}
