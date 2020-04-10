package nextstep.ladder;

import nextstep.ladder.domain.*;
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
        LadderGameInfo ladderGameInfo = new LadderGameInfo(namesToPersons(ladderRequestDto), resultStiringToResults(ladderRequestDto));
        List<Person> persons = ladderGameInfo.getPersons();

        return new LadderResponseDto(Ladder.of(persons, heightOfLadder), ladderGameInfo);
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

    public static List<Step> findResult(Ladder ladder, List<String> names) {
        return ladder.findResult(names);
    }
}
