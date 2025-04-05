package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    public void 사다리는_지정한_높이만큼_라인을_생성한다() {
        int numberOfPeople = 4;
        int height = 5;

        Ladder ladder = new Ladder(numberOfPeople, height);
        List<Line> lines = ladder.lines();

        assertThat(lines).hasSize(height);
    }

    @Test
    public void 각_라인은_사람_수보다_1_작은_포인트를_가진다() {
        int numberOfPeople = 4;
        int height = 3;

        Ladder ladder = new Ladder(numberOfPeople, height);
        List<Line> lines = ladder.lines();
        lines.forEach(line ->
            assertThat(line).isNotNull()
        );
    }

}
