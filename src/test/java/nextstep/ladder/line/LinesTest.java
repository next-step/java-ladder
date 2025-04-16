package nextstep.ladder.line;

import nextstep.ladder.Name;
import nextstep.ladder.Names;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static nextstep.ladder.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    @Test
    void getResults() {
        List<Line> lineList = List.of(
                new Line(List.of(RIGHT, LEFT, STRAIGHT)),
                new Line(List.of(STRAIGHT, RIGHT, LEFT)),
                new Line(List.of(STRAIGHT, STRAIGHT, STRAIGHT))
        );

        Lines lines = new Lines(lineList);
        Names players = Names.of(new String[]{"a", "b", "c"});
        Names results = Names.of(new String[]{"x", "y", "z"});
        Map<Name, Name> resultsMap = lines.getResults(players, results);

        assertThat(resultsMap.get(new Name("a"))).isEqualTo(new Name("z"));
        assertThat(resultsMap.get(new Name("b"))).isEqualTo(new Name("x"));
        assertThat(resultsMap.get(new Name("c"))).isEqualTo(new Name("y"));
    }
}
