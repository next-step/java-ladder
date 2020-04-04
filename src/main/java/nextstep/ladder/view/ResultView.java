package nextstep.ladder.view;

import nextstep.ladder.domain.*;

import static nextstep.ladder.domain.Point.TRUE;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String HORIZONTAL_LINE = "-";
    private static final String EMPTY_LINE = " ";
    private static final String VERTICAL_LINE = "|";

    public static void displayResult(LadderGame ladderGame) {
        System.out.println(RESULT_MESSAGE);
        displayNames(ladderGame.getParticipants());
        displayLadder(ladderGame.getLadder());
    }

    private static void displayNames(Participants participants) {
        String format = "%-" + (Participant.MAX_NAME_LENGTH + 1) + "s";
        for (Participant participant : participants) {
            System.out.print(String.format(format, participant.getName()));
        }
        System.out.println();
    }

    private static void displayLadder(Ladder ladder) {
        for (HorizontalLine horizontalLine : ladder.getLadder()) {
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
        if (point == TRUE) {
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
