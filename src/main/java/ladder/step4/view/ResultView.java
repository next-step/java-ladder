package ladder.step4.view;

import ladder.step4.domain.*;

import static java.util.stream.Collectors.joining;

public class ResultView {
    private static final ResultView INSTANCE = new ResultView();
    private static final String IS_LINE = "-----|";
    private static final String NO_LINE = "     |";
    private static final String NEW_LINE = System.lineSeparator();

    private ResultView() { }

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
        long limit = ladderLine.stream().count() - 1;
        return NO_LINE + ladderLine.stream()
                                   .map(v -> v.isRight() ? IS_LINE : NO_LINE)
                                   .limit(limit)
                                   .collect(joining(""));
    }

    public void viewResult (LadderGame ladderGame, Participants participants, String target) {
        boolean isAll = target.equals("all");
        System.out.println(NEW_LINE + "실행결과");
        System.out.println(
          isAll ? viewAllResult(ladderGame, participants)
                : ladderGame.getResultOfString(target).getValue()
        );
    }

    private String viewAllResult(LadderGame ladderGame, Participants participants) {
        return participants.stream()
                           .map(participant -> String.format(
                               "%s : %s",
                               participant.getValue(),
                               ladderGame.getResult(participant).getValue()
                           ))
                           .collect(joining(NEW_LINE));
    }

}
