package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    public void 사다리는_지정한_높이만큼_라인을_생성한다() {
        int numberOfPeople = 4;
        Height height = new Height(5);

        Ladder ladder = new Ladder(numberOfPeople, height);
        List<Line> lines = ladder.lines();

        assertThat(lines).hasSize(height.getHeight());
    }

    @Test
    public void 각_라인은_사람_수보다_1_작은_포인트를_가진다() {
        int numberOfPeople = 4;
        Height height = new Height(3);

        Ladder ladder = new Ladder(numberOfPeople, height);
        List<Line> lines = ladder.lines();
        lines.forEach(line ->
            assertThat(line).isNotNull()
        );
    }

    @Test
    void move_정해진_사다리에서_위치_이동_결과_확인() {
        /*
        * line1:        |-----|     |
        * line2:        |     |-----|
        * */
        Line line1 = new Line(Arrays.asList(new Point(true), new Point(false)));
        Line line2 = new Line(Arrays.asList(new Point(false), new Point(true)));

        Ladder ladder = new Ladder(Arrays.asList(line1, line2));

        assertThat(ladder.finalIndex(0)).isEqualTo(2);
        assertThat(ladder.finalIndex(1)).isEqualTo(0);
        assertThat(ladder.finalIndex(2)).isEqualTo(1);
    }


}
