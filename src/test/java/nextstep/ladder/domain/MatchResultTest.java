package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class MatchResultTest {

    private People people;
    private Line line1, line2, line3, line4, line5;
    private Lines lines;
    private ExecuteResults executeResults;
    private Ladder ladder;

    @BeforeEach
    void setup() {
        people = new People(new String[]{"pobi, honux, crong, jk"});

        line1 = new Line(Arrays.asList(true, false, true));
        line2 = new Line(Arrays.asList(false, true, false));
        line3 = new Line(Arrays.asList(true, false, false));
        line4 = new Line(Arrays.asList(false, true, false));
        line5 = new Line(Arrays.asList(true, false, true));
        lines = new Lines(Arrays.asList(line1, line2, line3, line4, line5));

        executeResults = new ExecuteResults(new String[]{"꽝", "5000", "꽝", "3000"});

        ladder = new Ladder(people, executeResults, lines);
    }

    @Test
    void 특정인의_결과_확인() {
        //given
        MatchResult matchResult = new MatchResult(ladder);

        //when
        String result = matchResult.result("pobi");

        //then
        assertThat(result).isEqualTo("꽝");
    }
}
