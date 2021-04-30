package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LadderTest {
    @Test
    public void create() {
        final int width = 5;

        final List<LadderLine> ladderLines = Arrays.asList(
                LadderLine.from(width),
                LadderLine.from(width),
                LadderLine.from(width),
                LadderLine.from(width)
        );

        assertThatCode(() -> new Ladder(ladderLines))
                .doesNotThrowAnyException();
    }

    @Test
    public void ladderResults() {
        final Point rightPoint = new Point(Direction.RIGHT);
        final Point leftPoint = new Point(Direction.LEFT);
        final Point nonePoint = new Point(Direction.NONE);

        final Person pobi = new Person("pobi");
        final Person honux = new Person("honux");
        final Person crong = new Person("crong");
        final Person jk = new Person("jk");

        final Prize blank = new Prize("꽝");
        final Prize threeThousand = new Prize("3000");
        final Prize fiveThousand = new Prize("5000");

        final List<LadderLine> ladderLines = Arrays.asList(
                new LadderLine(Arrays.asList(rightPoint, leftPoint, rightPoint, leftPoint)),
                new LadderLine(Arrays.asList(nonePoint, rightPoint, leftPoint, nonePoint)),
                new LadderLine(Arrays.asList(rightPoint, leftPoint, nonePoint, nonePoint)),
                new LadderLine(Arrays.asList(nonePoint, rightPoint, leftPoint, nonePoint)),
                new LadderLine(Arrays.asList(rightPoint, leftPoint, rightPoint, leftPoint))
        );

        final Ladder ladder = new Ladder(ladderLines);

        final Names names = new Names(Arrays.asList(pobi, honux, crong, jk));
        final Prizes prizes = new Prizes(Arrays.asList(blank, fiveThousand, blank, threeThousand));

        final LadderResults expected = new LadderResults(Arrays.asList(
                new LadderResult(pobi, blank),
                new LadderResult(honux, threeThousand),
                new LadderResult(crong, blank),
                new LadderResult(jk, fiveThousand)
        ));

        final LadderResults actual = ladder.ladderResults(names, prizes);

        assertThat(actual).isEqualTo(expected);
    }
}
