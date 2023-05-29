package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MatchResultTest {

    private People people;
    private Lines lines;
    private ExecuteResults executeResults;
    private Ladder ladder;

    @BeforeEach
    void setup() {
        people = new People(new String[]{"pobi", "honux", "crong", "jk"});
        int verticalLineSize = people.value().size();

        lines = new Lines(Arrays.asList(
                new Line(Arrays.asList(true, false, true)),
                new Line(Arrays.asList(false, true, false)),
                new Line(Arrays.asList(true, false, false)),
                new Line(Arrays.asList(false, true, false)),
                new Line(Arrays.asList(true, false, true))
        ));

//        executeResults = new ExecuteResults(new String[]{"꽝1", "5000", "꽝2", "3000"});

        ladder = new Ladder(verticalLineSize, lines);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:3", "2:2", "3:1"}, delimiter = ':')
    void result_메서드(int input, int output) {
        //given
        Match match = new Match(ladder);

        //when
        int resultIdx = match.resultIdx(input);

        //then
        assertThat(resultIdx).isEqualTo(output);
    }
}
