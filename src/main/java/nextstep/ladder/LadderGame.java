package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Person;
import nextstep.ladder.domain.step.strategy.MovableBothSide;
import nextstep.ladder.domain.step.strategy.MovablePrev;
import nextstep.ladder.dto.LadderRequestDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    private static final int ONE = 1;
    private static final int FIRST_PERSON = 0;
    private static final String DELIMITER = ",";

    public static Ladder run(LadderRequestDto ladderRequestDto) {
        int heightOfLadder = ladderRequestDto.getHeight();
        List<Person> persons = namesToPersons(ladderRequestDto);

        List<Line> lines = new ArrayList<>();
        Line previousLine = Line.first(persons.get(FIRST_PERSON), heightOfLadder);
        lines.add(previousLine);
        generateLines(persons, lines, previousLine);
        return new Ladder(lines, heightOfLadder);
    }

    private static void generateLines(List<Person> persons, List<Line> lines, Line previousLine) {
        for (int i = 1; i < persons.size(); i++) {
            previousLine = getLine(persons, previousLine, i);
            lines.add(previousLine);
        }
    }

    private static List<Person> namesToPersons(LadderRequestDto ladderRequestDto) {
        return Arrays.asList(ladderRequestDto.getNames().split(DELIMITER)).stream()
                .map(Person::new)
                .collect(Collectors.toList());
    }

    private static Line getLine(List<Person> persons, Line previousLine, int i) {
        if (i == lastPersonsIndex(persons)) {
            return Line.of(persons.get(i), previousLine.getSteps(), new MovablePrev());
        }
        return Line.of(persons.get(i), previousLine.getSteps(), new MovableBothSide());
    }

    private static int lastPersonsIndex(List<Person> persons) {
        return persons.size() - ONE;
    }

}
