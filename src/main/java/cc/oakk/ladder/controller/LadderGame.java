package cc.oakk.ladder.controller;

import cc.oakk.ladder.model.ladder.Ladder;
import cc.oakk.ladder.model.person.Person;
import cc.oakk.ladder.model.person.Persons;
import cc.oakk.ladder.model.result.Result;
import cc.oakk.ladder.model.result.Results;
import cc.oakk.ladder.model.size.LadderHeight;
import cc.oakk.ladder.model.trace.Trace;
import cc.oakk.ladder.model.trace.dto.TraceResultsDto;
import cc.oakk.ladder.util.RandomUtils;
import cc.oakk.ladder.view.InputView;
import cc.oakk.ladder.view.QueryView;
import cc.oakk.ladder.view.ResultView;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static cc.oakk.ladder.util.ValidationUtils.tryUntilSuccess;

public class LadderGame {
    public static final Person ALL = new Person("all");

    private final InputView inputView;
    private final ResultView resultView;
    private final QueryView queryView;

    public LadderGame(InputView inputView, ResultView resultView, QueryView queryView) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.queryView = queryView;
    }

    public void start() {
        Persons persons = getPersons();
        Results results = getResults(persons);
        LadderHeight height = getHeight();

        Ladder ladder = new Ladder(persons.size(), height.get());
        initLadder(ladder);

        resultView.printHeader();
        resultView.printPersons(persons);
        resultView.printLadder(ladder.getDto());
        resultView.printResults(results);

        query(ladder.traceAll().getDto(), persons, results);
    }

    private void query(TraceResultsDto traceResults, Persons persons, Results results) {
        Person wantedPerson = tryUntilSuccess(() -> new Person(queryView.getWantedPerson()), queryView::printError);
        if (ALL.equals(wantedPerson)) {
            queryView.printTraceResults(traceResults, persons, results);
            return;
        }

        int indexOfPerson = persons.find(wantedPerson);
        if (indexOfPerson == Persons.NOT_FOUND) {
            queryView.printError(new IllegalArgumentException("존재하지 않는 사람입니다."));
            query(traceResults, persons, results);
            return;
        }
        int indexOfResults = traceResults.getTraceResult(Trace.of(indexOfPerson)).get();
        queryView.printResult(results.get(indexOfResults));
        query(traceResults, persons, results);
    }

    private LadderHeight getHeight() {
        return tryUntilSuccess(() -> new LadderHeight(inputView.getLadderHeight()),
                inputView::printError);
    }

    private Results getResults(Persons persons) {
        return tryUntilSuccess(() -> new Results(Arrays.stream(inputView.getResultNames(persons.size()))
                .map(Result::new)
                .collect(Collectors.toList())), inputView::printError);
    }

    private Persons getPersons() {
        return tryUntilSuccess(() -> new Persons(Arrays.stream(inputView.getPersonNames())
                .map(Person::new)
                .collect(Collectors.toList())), inputView::printError);
    }

    private void initLadder(Ladder ladder) {
        ladder.initLines(width -> IntStream.iterate(RandomUtils.nextInt(2), i -> i + 2)
                .limit(width / 2)
                .filter(i -> RandomUtils.nextBoolean())
                .toArray());
    }
}
