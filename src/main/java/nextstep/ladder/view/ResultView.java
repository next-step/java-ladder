package nextstep.ladder.view;

import nextstep.ladder.domain.HorizontalLine;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Participant;
import nextstep.ladder.domain.Point;

import java.util.List;

public class ResultView {
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String HORIZONTAL_LINE = "-";
    private static final String EMPTY_LINE = " ";
    private static final String VERTICAL_LINE = "|";

    public static void displayResult(List<String> names, Ladder ladder) {
        System.out.println(RESULT_MESSAGE);
        displayNames(names);
        displayLadder(ladder);
    }

    private static void displayNames(List<String> names) {
        for(String name: names) {
            System.out.print(String.format("%-"+6+ "s", name));
        }
        System.out.println();
    }

    private static void displayLadder(Ladder ladder) {
        for(HorizontalLine horizontalLine: ladder.getLadder()) {
            displayHorizontalLine(horizontalLine);
            System.out.println();
        }
    }

    private static void displayHorizontalLine(HorizontalLine horizontalLine) {
        for(Point point: horizontalLine) {
            System.out.print(VERTICAL_LINE);
            displayHorizontalLine(point);

        }
    }
    private static void displayHorizontalLine(Point point) {
        if(point.hasRightDirection()) {
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
