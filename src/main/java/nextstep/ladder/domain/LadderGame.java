package nextstep.ladder.domain;

import nextstep.ladder.strategy.LineCreatableStrategy;
import nextstep.ladder.vo.Result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    public static final String DELIMITER = ",";

    private final LineCreatableStrategy lineCreatableStrategy;

    public LadderGame(final LineCreatableStrategy lineCreatableStrategy) {
        this.lineCreatableStrategy = lineCreatableStrategy;
    }

    public Result play(final String names, final String executeResult, final int countLadderHeight) {
        List<Person> persons = createPerson(names);
        List<Line> lines = createLadder(countLadderHeight, persons.size());
        List<Winner> winners = findWinners(executeResult, persons, lines);
        return new Result(persons, lines, winners);
    }

    private static List<Winner> findWinners(String executeResult, List<Person> persons, List<Line> lines) {
        List<Person> movedPersons = new ArrayList<>(persons);
        for (Line line : lines) {
            movedPersons = line.movePersons(movedPersons);
        }

        String[] values = executeResult.split(DELIMITER);

        List<Winner> winners = new ArrayList<>();
        for(int i = 0; i < values.length; i++) {
            winners.add(new Winner(movedPersons.get(i), values[i]));
        }
        return winners;
    }

    private List<Person> createPerson(final String names) {
        return Arrays.stream(names.split(DELIMITER))
                .map(Person::new)
                .collect(Collectors.toList());
    }

    private List<Line> createLadder(final int countLadderHeight, final int countOfPerson) {
        return IntStream.range(0, countLadderHeight)
                .mapToObj(i -> lineCreatableStrategy.create(countOfPerson))
                .collect(Collectors.toList());
    }
}
