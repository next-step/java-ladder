package nextstep.ladder.domain;

import nextstep.ladder.strategy.LineCreatableStrategy;
import nextstep.ladder.vo.Input;
import nextstep.ladder.vo.Result;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {
    public static final String DILIMITER = ",";

    private final LineCreatableStrategy lineCreatableStrategy;

    public LadderGame(final LineCreatableStrategy lineCreatableStrategy) {
        this.lineCreatableStrategy = lineCreatableStrategy;
    }

    public Result play(final Input input) {
        List<Person> persons = createPerson(input.getNames());
        List<Line> lines = createLadder(input.getNumber(), persons.size());
        return new Result(persons, lines);
    }

    private List<Person> createPerson(final String names) {
        return Arrays.stream(names.split(DILIMITER))
                .map(Person::new)
                .collect(Collectors.toList());
    }

    private List<Line> createLadder(final int countLadderHeight, final int countOfPerson) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < countLadderHeight; i++) {
            Line line = lineCreatableStrategy.create(countOfPerson);
            lines.add(line);
        }
        return lines;
    }
}
