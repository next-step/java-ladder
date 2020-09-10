package cc.oakk.ladder.controller;

import cc.oakk.ladder.model.ladder.Ladder;
import cc.oakk.ladder.model.person.Person;
import cc.oakk.ladder.model.person.Persons;
import cc.oakk.ladder.model.size.LadderHeight;
import cc.oakk.ladder.util.RandomUtils;
import cc.oakk.ladder.util.ValidationUtils;
import cc.oakk.ladder.view.InputView;
import cc.oakk.ladder.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static cc.oakk.ladder.util.ValidationUtils.tryUntilSuccess;

public class LadderGame {
    private final InputView inputView;
    private final ResultView resultView;

    public LadderGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        Persons persons = getPersons();
        LadderHeight height = getHeight();

        Ladder ladder = new Ladder(persons.size(), height.get());
        initLadder(ladder);

        resultView.printHeader();
        resultView.printPersons(persons);
        resultView.printLadder(ladder.getDto());
    }

    private LadderHeight getHeight() {
        return tryUntilSuccess(() -> new LadderHeight(inputView.getLadderHeight()),
                inputView::printError);
    }

    private Persons getPersons() {
        return tryUntilSuccess(() -> new Persons(Arrays.stream(inputView.getPersonNames())
                .map(Person::new)
                .collect(Collectors.toList())), inputView::printError);
    }

    private void initLadder(Ladder ladder) {
        ladder.initLines(width -> {
            int even = RandomUtils.nextInt(2);
            return IntStream.range(0, width - 1)
                    .filter(i -> i % 2 == even && RandomUtils.nextBoolean())
                    .toArray();
        });
    }
}
