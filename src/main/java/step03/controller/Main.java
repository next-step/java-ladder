package step03.controller;

import step03.domain.Ladder;
import step03.domain.Matcher;
import step03.domain.NamesOfResult;
import step03.domain.Participants;
import step03.view.InputView;
import step03.view.ResultView;
import strategy.RandomPointStrategy;

public class Main {
    private static final String ALL = "all";
    public static void main(String[] args) {

        Participants participants = readParticipants();
        NamesOfResult namesOfResult = readNamesOfResults();

        Matcher.Builder matcherBuilder = Matcher.Builder.of(participants)
                .namesOfResult(namesOfResult);

        int countOfSteps = InputView.readCountOfSteps();

        Ladder ladder = Ladder.of(countOfSteps, participants.size(), RandomPointStrategy.of());
        ResultView.printLadderWithNames(participants, namesOfResult, ladder.getLadder());

        Matcher matcher = matcherBuilder.matchedTable(ladder.getResultTable()).build();

        printResult(matcher);
    }

    public static Participants readParticipants() {
        String namesOfParticipants = InputView.readNamesOfParticipants();
        return Participants.of(namesOfParticipants);
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
