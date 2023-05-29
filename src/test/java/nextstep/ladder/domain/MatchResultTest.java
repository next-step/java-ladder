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
    private InputOutput inputOutput;

    @BeforeEach
    void setup() {
        people = new People(new String[]{"pobi", "honux", "crong", "jk"});
        executeResults = new ExecuteResults(new String[]{"꽝1", "5000", "꽝2", "3000"});
        inputOutput = new InputOutput(people, executeResults);

        lines = new Lines(Arrays.asList(
                new Line(Arrays.asList(true, false, true)),
                new Line(Arrays.asList(false, true, false)),
                new Line(Arrays.asList(true, false, false)),
                new Line(Arrays.asList(false, true, false)),
                new Line(Arrays.asList(true, false, true))
        ));
        int verticalLineSize = people.value().size();
        ladder = new Ladder(verticalLineSize, lines);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:3", "2:2", "3:1"}, delimiter = ':')
    void findOutputIdx(int inputIdx, int outputIdx) {
        //given
        Match match = new Match(ladder);

        //when
        int resultIdx = match.findOutputIdx(inputIdx);

        //then
        assertThat(resultIdx).isEqualTo(outputIdx);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi:꽝1", "honux:3000", "crong:꽝2", "jk:5000"}, delimiter = ':')
    void 사다리_결과(String input, String output) {
        //given
        Match match = new Match(inputOutput, ladder);

        //when
        String result = match.result(input);

        //then
        assertThat(result).isEqualTo(output);
    }
}
