package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import java.util.List;
import java.util.Map;

public class ResultView {
    private static final String LADDER_MESSAGE = "사다리 결과";
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String HORIZONTAL_LINE = "-";
    private static final String EMPTY_LINE = " ";
    private static final String VERTICAL_LINE = "|";
    private static final String PRINT_ALL_RESULT_COMMAND = "all";

    public static void displayLadder(LadderGame ladderGame) {
        System.out.println(LADDER_MESSAGE);
        displayNames(ladderGame.getParticipantNames());
        displayLadder(ladderGame.getLadder());
        displayPrizes(ladderGame.getPrizeNames());
    }

    public static void displayResult(String command, LadderGame ladderGame) {
        if(command.equals(PRINT_ALL_RESULT_COMMAND)) {
            ResultView.displayResult(ladderGame.prizeAll());
            return;
        }
        ResultView.displayResult(ladderGame.prize(command));
    }

    public static void displayResult(Prize prize) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(prize.getName());
    }

    public static void displayResult(Map<Participant, Prize> result) {
        System.out.println(RESULT_MESSAGE);
        result.forEach((participant, prize) -> {
            System.out.println(participant.getName() + ":" + prize.getName());
        });
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
        for (HorizontalLine horizontalLine : ladder) {
            displayHorizontalLine(horizontalLine);
            System.out.println();
        }
    }

    private static void displayHorizontalLine(HorizontalLine horizontalLine) {
        for (Point point : horizontalLine) {
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
