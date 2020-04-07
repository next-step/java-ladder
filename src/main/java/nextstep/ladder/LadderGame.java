package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Person;
import nextstep.ladder.domain.step.Step;
import nextstep.ladder.dto.LadderRequestDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private static final String DELIMITER = ",";

    public static Ladder makeLadder(LadderRequestDto ladderRequestDto) {
        int heightOfLadder = ladderRequestDto.getHeight();
        List<Person> persons = namesToPersons(ladderRequestDto);
        return Ladder.of(persons, heightOfLadder);
    }

    private static List<Person> namesToPersons(LadderRequestDto ladderRequestDto) {
        return Arrays.asList(ladderRequestDto.getNames().split(DELIMITER)).stream()
                .map(Person::new)
                .collect(Collectors.toList());
    }

    public static void run(Ladder ladder, String name, String results) {
        Step result = ladder.start(name);
        String[] split = results.split(",");
        System.out.println(name + " : " +split[result.getLine()]);
    }
}
