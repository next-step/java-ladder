package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Players;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {

    private Ladder ladder;
    @BeforeEach
    void init() {
        List<Line> lineList = new ArrayList<>();
        lineList.add(new Line(Arrays.asList(false, true, false)));
        lineList.add(new Line(Arrays.asList(true, false, false)));
        lineList.add(new Line(Arrays.asList(false, false, true)));
        lineList.add(new Line(Arrays.asList(true, false, false)));
        lineList.add(new Line(Arrays.asList(false, true, false)));
        ladder = new Ladder(lineList);

    }
    @Test
    void runTest() {
        Players players = new Players(new String[]{"A", "B", "C", "D"});
        ladder.run(players);

        assertThat(players).isEqualTo(new Players(new String[]{"A", "D", "C", "B"}));
    }
}
