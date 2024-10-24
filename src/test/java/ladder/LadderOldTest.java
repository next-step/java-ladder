package ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class LadderOldTest {

    @Test
    void 생성() {
        List<LineOld> lineOlds = List.of(
            new LineOld(2, new FixedLineGenerator()),
            new LineOld(2, new FixedLineGenerator()),
            new LineOld(2, new FixedLineGenerator())
        );
        LadderOld ladderOld = new LadderOld(lineOlds);

        assertThat(ladderOld).isEqualTo(new LadderOld(lineOlds));
    }

    @Test
    void 시작위치를_전달하면_최종위치를_반환한다() {
        List<LineOld> lineOlds = List.of(
            new LineOld(true, false),
            new LineOld(true, false),
            new LineOld(true, false)
        );
        LadderOld ladderOld = new LadderOld(lineOlds);
        int resultPoint = ladderOld.runPerPerson(0);

        assertThat(resultPoint).isEqualTo(1);
    }

    @Test
    void 전체_결과를_반환한다() {
        List<LineOld> lineOlds = List.of(
            new LineOld(true),
            new LineOld(true),
            new LineOld(true)
        );
        LadderOld ladderOld = new LadderOld(lineOlds);
        PlayersOld playersOld = new PlayersOld("pobi", "lili");
        InputResult inputResult = new InputResult("꽝,3000", playersOld.size());
        LadderResult ladderResult = ladderOld.run(playersOld, inputResult);

        Map<String, String> values = Map.of("pobi", "3000", "lili", "꽝");

        assertThat(ladderResult).isEqualTo(new LadderResult(values));
    }
}
