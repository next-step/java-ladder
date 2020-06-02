package ladder.step3.view;

import ladder.step3.domain.*;

import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class ResultView {
    private static final ResultView INSTANCE = new ResultView();
    private static final String IS_LINE = "-----|";
    private static final String NO_LINE = "     |";
    private static final String NEW_LINE = System.lineSeparator();

    private ResultView() {
    }

    public static ResultView getInstance() {
        return INSTANCE;
    }

    public void viewLadder(Ladder ladder, Participants participants, LadderResults ladderResults) {
        System.out.printf(
            NEW_LINE + "사다리결과%s%s%s",
            NEW_LINE + toStringOfParticipants(participants),
            NEW_LINE + toStringOfLadder(ladder),
            NEW_LINE + toStringOfLadderResults(ladderResults)
        );
    }

    private String toStringOfParticipants(Participants participants) {
        return participants.stream()
                           .map(participant -> String.format("%6s", participant.getValue()))
                           .collect(joining(""));
    }

    private String toStringOfLadder(Ladder ladder) {
        return ladder.stream()
                     .map(this::toStringOfLadderLine)
                     .collect(joining(NEW_LINE));
    }

    private String toStringOfLadderResults(LadderResults results) {
        return results.stream()
                      .map(participant -> String.format("%6s", participant.getValue()))
                      .collect(joining(""));
    }

    private String toStringOfLadderLine(LadderLine ladderLine) {
        return NO_LINE + ladderLine.stream()
                                   .map(v -> v ? IS_LINE : NO_LINE)
                                   .collect(joining(""));
    }


    public void viewSingleResult(LadderResult ladderResult) {
        System.out.printf(
            NEW_LINE + "실행결과%s",
            NEW_LINE + ladderResult.getValue()
        );
    }

    public void viewAllResult(LadderGame ladderGame, Participants participants) {
        System.out.printf(
            NEW_LINE + "실행결과%s",
            NEW_LINE + participants.stream()
                                   .map(participant -> String.format(
                                       "%s : %s",
                                       participant.getValue(),
                                       ladderGame.getResult(participant).getValue()
                                   ))
                                   .collect(joining(NEW_LINE))
        );
    }

}
