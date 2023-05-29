package nextstep.ladder;

import nextstep.ladder.drawPolicy.AllDraw;
import nextstep.ladder.view.ResultView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderRowTest {

    LadderRow ladderRow;

    @BeforeEach
    void init() {
        ladderRow = new LadderRow(5, new AllDraw());
    }

    @Test
    void getPoints() {
        var acutualPoints = ladderRow.getPoints();
        var expectPoints = new LadderRow(5, new AllDraw()).getPoints();

        assertThat(acutualPoints).isEqualTo(expectPoints);
    }
}
