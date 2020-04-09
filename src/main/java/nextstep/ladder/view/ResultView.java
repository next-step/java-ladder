package nextstep.ladder.view;

import nextstep.ladder.domain.game.LadderGame;
import nextstep.ladder.domain.game.LadderGameResult;
import nextstep.ladder.domain.game.Participant;
import nextstep.ladder.domain.line.Ladder;
import nextstep.ladder.domain.line.LadderLine;
import nextstep.ladder.domain.line.Point;

import java.util.List;

public class ResultView {
    private static final String LADDER_MESSAGE = "사다리 결과";
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String HORIZONTAL_LINE = "-";
    private static final String EMPTY_LINE = " ";
    private static final String VERTICAL_LINE = "|";


    public static void displayLadder(LadderGame ladderGame) {
        System.out.println(LADDER_MESSAGE);
        displayNames(ladderGame.getParticipantNames());
        displayLadder(ladderGame.getLadder());
        displayPrizes(ladderGame.getPrizeNames());
    }

    public static void displayResult(LadderGameResult ladderGameResult) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(ladderGameResult.getPrizeName());
    }

    public static void displayResult(List<LadderGameResult> result) {
        System.out.println(RESULT_MESSAGE);
        for (LadderGameResult ladderGameResult : result) {
            System.out.println(ladderGameResult.getParticipantName() +
                    ":" + ladderGameResult.getPrizeName());
        }
    }

    private static void displayNames(List<String> participantNames) {
        String format = "%-" + (Participant.MAX_NAME_LENGTH + 1) + "s";
        for (String name : participantNames) {
            System.out.print(String.format(format, name));
        }
        System.out.println();
    }

    private static void displayPrizes(List<String> prizeNames) {
        String format = "%-" + (Participant.MAX_NAME_LENGTH + 1) + "s";
        for (String name : prizeNames) {
            System.out.print(String.format(format, name));
        }
        System.out.println();
    }

    private static void displayLadder(Ladder ladder) {
        for (LadderLine ladderLine : ladder) {
            displayHorizontalLine(ladderLine);
            System.out.println();
        }
    }

    private static void displayHorizontalLine(LadderLine ladderLine) {
        for (Point point : ladderLine) {
            System.out.print(VERTICAL_LINE);
            displayHorizontalLine(point);

        }
    }

    private static void displayHorizontalLine(Point point) {
        if (point.hasRightDirection()) {
            System.out.print(new String(new char[Participant.MAX_NAME_LENGTH])
                    .replace("\0", HORIZONTAL_LINE));
            return;
        }
        System.out.print(new String(new char[Participant.MAX_NAME_LENGTH])
                .replace("\0", EMPTY_LINE));
    }

    private ResultView() {
    }
}
