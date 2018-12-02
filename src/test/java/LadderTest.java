import domain.Ladder;
import domain.Line;
import org.junit.Test;
import view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    public void 사다리타기테스트() {
        int depth = 5;
        int length = 4;
        Ladder ladder = Ladder.from(depth, length);
        List<Integer> resultBox = ladder.followLadder();
        assertThat(resultBox).hasSize(4);
        assertThat(resultBox).contains(0, 1, 2, 3);
    }
}
