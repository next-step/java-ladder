package ui;

import domain.*;

import java.util.Collections;

import static common.CommonConstants.JOIN_DELIMITER_BLANK;

public class ResultView {
    private static final String VERTICAL = "|";
    private static final String HORIZONTAL = "-";
    private static final String BLANK = " ";
    private static final String NEWLINE = "\n";
    private static final int NUMBER_OF_TEMPLATE_BLANK = 4;
    private static final int NUMBER_OF_TEMPLATE_HORIZONTAL = 5;
    private static final int NUMBER_OF_NAME_PADDING = 5;

    public static void print(LadderGame ladderGame) {
        printPlayer(ladderGame.getPlayerNames());
        printLadder(ladderGame.getLadder());
    }

    private static void printPlayer(PlayerNames playerNames) {
        playerNames.stream().forEach(s -> {
            System.out.print(padNamesAsFive(s).concat(BLANK));
        });
        System.out.print(NEWLINE);
    }

    public static void printLadder(Ladder ladder) {
        ladder.getLines().stream().map(Line::getPoints).forEach(points -> {
            System.out.print(String.join(JOIN_DELIMITER_BLANK, Collections.nCopies(NUMBER_OF_TEMPLATE_BLANK, BLANK)));
            points.stream().forEach( point -> drawPoint(point.isPresent()) );
            System.out.println(VERTICAL);
        });
    }

    private static String padNamesAsFive(String inputString) {
        return String.format("%1$" + NUMBER_OF_NAME_PADDING + "s", inputString);
    }

    private static void drawPoint(boolean isPresent) {
        if(isPresent) {
            System.out.print(VERTICAL);
            System.out.print(String.join(JOIN_DELIMITER_BLANK, Collections.nCopies(NUMBER_OF_TEMPLATE_HORIZONTAL, HORIZONTAL)));
            return;
        }
        System.out.print(VERTICAL);
        System.out.print(String.join(JOIN_DELIMITER_BLANK, Collections.nCopies(NUMBER_OF_TEMPLATE_HORIZONTAL, BLANK)));
    }
}
