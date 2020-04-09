package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Person;
import nextstep.ladder.domain.Result;
import nextstep.ladder.domain.Results;
import nextstep.ladder.domain.step.Step;
import nextstep.ladder.dto.LadderRequestDto;
import nextstep.ladder.dto.LadderResponseDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private static final String DELIMITER = ",";

    public static LadderResponseDto makeLadder(LadderRequestDto ladderRequestDto) {
        int heightOfLadder = ladderRequestDto.getHeight();
        List<Person> persons = namesToPersons(ladderRequestDto);
        Results results = new Results(resultStiringToResults(ladderRequestDto), persons.size());

        return new LadderResponseDto(Ladder.of(persons, heightOfLadder), persons, results);
    }

    private static List<Person> namesToPersons(LadderRequestDto ladderRequestDto) {
        return Arrays.asList(ladderRequestDto.getNames().split(DELIMITER)).stream()
                .map(Person::new)
                .collect(Collectors.toList());
    }

    private static List<Result> resultStiringToResults(LadderRequestDto ladderRequestDto) {
        return Arrays.asList(ladderRequestDto.getResults().split(DELIMITER)).stream()
                .map(Result::new)
                .collect(Collectors.toList());
    }

    public static List<Step> findAll(Ladder ladder) {
        return ladder.findAll();
    }

    public static Step findResult(Ladder ladder, String name) {
        return ladder.findResult(name);
    }
}
