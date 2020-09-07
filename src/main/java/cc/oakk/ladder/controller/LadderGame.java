package cc.oakk.ladder.controller;

import cc.oakk.ladder.model.Ladder;
import cc.oakk.ladder.model.Person;
import cc.oakk.ladder.model.size.LadderHeight;
import cc.oakk.ladder.util.RandomUtils;
import cc.oakk.ladder.util.ValidationUtils;
import cc.oakk.ladder.view.InputView;
import cc.oakk.ladder.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {
    private final InputView inputView;
    private final ResultView resultView;

    public LadderGame(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void start() {
        List<Person> persons = ValidationUtils.tryUntilSuccess(() -> Arrays.stream(inputView.getPersonNames())
                .map(Person::new)
                .collect(Collectors.toList()), inputView::printError);

        LadderHeight height = ValidationUtils.tryUntilSuccess(() -> new LadderHeight(inputView.getLadderHeight()),
                inputView::printError);

        Ladder ladder = new Ladder(persons.size(), height.get());
        initLadder(ladder);

        resultView.printLadder(persons, ladder);
    }

    private void initLadder(Ladder ladder) {
        ladder.initLines(l -> {
            int even = RandomUtils.nextInt(2);
            return IntStream.range(0, l - 1)
                    .filter(i -> i % 2 == even)
                    .filter(i -> RandomUtils.nextInt(2) == RandomUtils.nextInt(2))
                    .toArray();
        });
    }
}
