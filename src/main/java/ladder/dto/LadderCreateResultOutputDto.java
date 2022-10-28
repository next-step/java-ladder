package ladder.dto;

import ladder.domain.ladder.ladderline.LadderLines;
import ladder.domain.person.People;
import ladder.domain.result.Results;

public class LadderCreateResultOutputDto {

    private final String resultOutput;

    public LadderCreateResultOutputDto(People people, LadderLines ladderLines, Results results) {
        this.resultOutput = people + "\n" +
                ladderLines + "\n" +
                results + "\n";
    }

    @Override
    public String toString() {
        return resultOutput;
    }
}
