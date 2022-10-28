package ladder.dto;

import ladder.domain.ladder.ladderline.LadderLines;
import ladder.domain.person.People;
import ladder.domain.result.Results;
import ladder.util.LadderOutputConverter;

public class LadderCreateResultOutputDto {

    private final String people;
    private final String ladderLines;
    private final String results;

    public LadderCreateResultOutputDto(People people, LadderLines ladderLines, Results results) {
        this.people = LadderOutputConverter.peopleName(people);
        this.ladderLines = LadderOutputConverter.ladderLinesOutput(ladderLines);
        this.results = LadderOutputConverter.resultOutput(results);
    }

    @Override
    public String toString() {
        return people + "\n" +
                ladderLines + "\n" +
                results + "\n";
    }
}
