package ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    void 생성() {
        List<Line> lines = List.of(
            new Line(2, new FixedLineGenerator()),
            new Line(2, new FixedLineGenerator()),
            new Line(2, new FixedLineGenerator())
        );
        Ladder ladder = new Ladder(lines);

        assertThat(ladder).isEqualTo(new Ladder(lines));
    }

    @Test
    void 시작위치를_전달하면_최종위치를_반환한다() {
        List<Line> lines = List.of(
            new Line(true, false),
            new Line(true, false),
            new Line(true, false)
        );
        Ladder ladder = new Ladder(lines);
        int resultPoint = ladder.runPerPerson(0);

        assertThat(resultPoint).isEqualTo(1);
    }

    @Test
    void 전체_결과를_반환한다() {
        List<Line> lines = List.of(
            new Line(true),
            new Line(true),
            new Line(true)
        );
        Ladder ladder = new Ladder(lines);
        Players players = new Players("pobi", "lili");
        InputResult inputResult = new InputResult("꽝,3000");
        LadderResult ladderResult = ladder.run(players, inputResult);

        Map<String, String> values = Map.of("pobi", "3000", "lili", "꽝");

        assertThat(ladderResult).isEqualTo(new LadderResult(values));
    }
}
