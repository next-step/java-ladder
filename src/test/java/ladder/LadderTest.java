package ladder;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.LinkedType;
import ladder.domain.Point;
import ladder.domain.generator.LadderGenerator;
import ladder.domain.generator.RandomLadderGenerator;
import ladder.support.FixedLadderGenerator;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    public static Ladder 높이4_참여자3_고정사다리_생성하기() {
        List<Point> type1 = Arrays.asList(
                new Point(0, LinkedType.ONLY_RIGHT_LINKED),
                new Point(1, LinkedType.ONLY_LEFT_LINKED),
                new Point(2, LinkedType.NEITHER_LINKED));
        List<Point> type2 = Arrays.asList(
                new Point(0, LinkedType.NEITHER_LINKED),
                new Point(1, LinkedType.ONLY_RIGHT_LINKED),
                new Point(2, LinkedType.ONLY_LEFT_LINKED));
        Line type1Line = new Line(type1);
        Line type2Line = new Line(type2);
        List<Line> lines = Arrays.asList(type1Line, type1Line, type2Line, type2Line);
        return new Ladder(lines);
    }

    @Test
    public void 높이5_참여자5인_사다리() {
        // given
        LadderGenerator ladderGenerator = new RandomLadderGenerator();
        // when
        Ladder ladder = ladderGenerator.generate(5, 5);
        // then
        System.out.println(ladder);
        assertThat(ladder.getNumberOfLines()).isEqualTo(5);
        assertThat(ladder.getCountOfPoints()).isEqualTo(5);
    }

    @Test
    public void 높이4_참여자3_고정사다리에서_이동하기() {
        // given
        LadderGenerator ladderGenerator = new FixedLadderGenerator(높이4_참여자3_고정사다리_생성하기());
        Ladder ladder = ladderGenerator.generate(3, 4);
        // then
        System.out.println(ladder);
        System.out.println(ladder.descend(1));
        assertThat(ladder.descend(1)).isEqualTo(1);
    }
}
