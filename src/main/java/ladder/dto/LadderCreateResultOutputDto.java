package ladder.dto;

import ladder.domain.LadderTextInput;
import ladder.domain.ladder.ladderline.LadderLines;
import ladder.domain.person.People;
import ladder.domain.person.Person;
import ladder.domain.Rewards;
import ladder.util.LadderOutputConverter;

import java.util.stream.Collectors;

public class LadderCreateResultOutputDto {

    private final String resultOutput;

    public LadderCreateResultOutputDto(People people, LadderLines ladderLines, Rewards rewards) {
        String peopleOutput = LadderOutputConverter.ladderTextOutput(people.people().stream()
                .map(Person::name)
                .map(LadderTextInput::new)
                .collect(Collectors.toList()));

        String ladderLinesOutput = LadderOutputConverter.ladderLinesOutput(ladderLines);

        String resultsOutput = LadderOutputConverter.ladderTextOutput(rewards.results());

        this.resultOutput = peopleOutput + "\n" +
                ladderLinesOutput + "\n" +
                resultsOutput + "\n";
    }

    @Override
    public String toString() {
        return resultOutput;
    }
}
