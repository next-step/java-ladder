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
        Lines lines = new Lines(List.of(
                new Line(List.of(Boolean.TRUE), 0),
                new Line(List.of(Boolean.FALSE), 0)));
        Names names = new Names(List.of(
                new Name("pobi"),
                new Name("honux")));
        Ladder ladder = new Ladder(names, lines);
        List<String> result = List.of("꽝", "3000");
        PlayerResults playerResults = new PlayerResults(ladder);

        LadderResult actual = new LadderResult(playerResults, result);
        Map<Name, String> values = new HashMap<>();
        values.put(new Name("pobi"), "3000");
        values.put(new Name("honux"), "꽝");
        LadderResult expected = new LadderResult(values);

        assertThat(actual).isEqualTo(expected);
    }
}
