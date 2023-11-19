package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {

    @Test
    @DisplayName("사다리로 결과를 알 수 있다")
    void ladderResult() {
        Ladder ladder = new Ladder(List.of(
                new Line(List.of(Point.first(true), Point.first(true).draw(false))),
                new Line(List.of(Point.first(false), Point.first(false).draw(false)))));
        Names names = new Names(List.of(
                new Name("pobi"),
                new Name("honux")));
        List<String> result = List.of("꽝", "3000");

        PlayerResults playerResults = new PlayerResults(names, ladder, result);

        LadderResult actual = new LadderResult(playerResults, ladder);
        Map<Name, String> values = new HashMap<>();
        values.put(new Name("pobi"), "3000");
        values.put(new Name("honux"), "꽝");
        List<Line> list = List.of(
                new Line(List.of(Point.first(true), Point.first(true).draw(false))),
                new Line(List.of(Point.first(false), Point.first(false).draw(false))));
        LadderResult expected = new LadderResult(values, list);

        assertThat(actual).isEqualTo(expected);
    }
}
