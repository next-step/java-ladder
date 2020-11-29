package step04.controller;

import step04.domain.Ladder;
import step04.domain.Matcher;
import step04.domain.NamesOfResult;
import step04.domain.Participants;
import step04.view.InputView;
import step04.view.ResultView;
import strategy.RandomPointStrategy;

public class Main {
    private static final String ALL = "all";
    public static void main(String[] args) {

        NamesOfParticipant namesOfParticipant = readParticipants();
        NamesOfResult namesOfResult = readNamesOfResults();

        Matcher.Builder matcherBuilder = Matcher.Builder.of(namesOfParticipant)
                .namesOfResult(namesOfResult);

        int countOfSteps = InputView.readCountOfSteps();

        Ladder ladder = Ladder.of(countOfSteps, namesOfParticipant.size(), RandomPointStrategy.of());
        ResultView.printLadderWithNames(namesOfParticipant, namesOfResult, ladder.getLadder());

        Matcher matcher = matcherBuilder.matchedTable(ladder.getResultTable()).build();

        printResult(matcher);
    }

    public static NamesOfParticipant readParticipants() {
        String namesOfParticipants = InputView.readNamesOfParticipants();
        return NamesOfParticipant.of(namesOfParticipants);
    }

    public static NamesOfResult readNamesOfResults() {
        String resultsOfLADDER = InputView.readResultsOfLadder();
        return NamesOfResult.of(resultsOfLADDER);
    }

    public static void printResult(Matcher matcher) {
        String target = InputView.readNamesOfParticipant();
        while(!ALL.equals(target)) {
            ResultView.printResult(matcher.getResultByParticipant(target));
            target = InputView.readNamesOfParticipant();
        }
        ResultView.printResults(matcher);
    }
}
