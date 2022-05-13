package nextstep.view;

import nextstep.domain.LadderLine;
import nextstep.domain.StartLadderGame;


public class ResultView {
    private static final String PAD = "     ";
    private static final String LPAD = "      ";
    private static final String USER_POINT = "|";
    private static final String LADDER_LINE = "-";
    private static final String BLANK = " ";
    private static final int CHECK_USER_POINT_INDEX = 6;

    public static void print(StartLadderGame startLadderGame) {
        System.out.println("실행결과\n");

        System.out.print(startLadderGame.getUsers().get(0).getUserName()
                + PAD.substring(startLadderGame.getUsers().get(0).getUserName().length()));
        for (int i = 1; i < startLadderGame.getUsers().size(); i++) {
            System.out.print(LPAD.substring(startLadderGame.getUsers().get(i).getUserName().length())
                    + startLadderGame.getUsers().get(i).getUserName());
        }

        System.out.println();

        for (LadderLine ladderLine : startLadderGame.getLadder().getLadderLines()) {
            System.out.print(PAD.substring(0, startLadderGame.getUsers().get(0).getUserName().length()) + USER_POINT);
            for (int i = 1; i < ladderLine.getPoints().size(); i++) {
                if (isUserPoint(i)) {
                    System.out.print(USER_POINT);
                }
                if (isLadderLine(i, ladderLine.getPoints().get(i))) {
                    System.out.print(LADDER_LINE);
                }
                if (isLadderBlankLine(i, ladderLine.getPoints().get(i))) {
                    System.out.print(BLANK);
                }
            }
            System.out.println();
        }
    }

    private static boolean isUserPoint(int index) {
        return index % CHECK_USER_POINT_INDEX == 0;
    }

    private static boolean isLadderLine(int index, boolean isLadderLine) {
        return index % CHECK_USER_POINT_INDEX != 0 && isLadderLine;
    }

    private static boolean isLadderBlankLine(int index, boolean isLadderLine) {
        return index % CHECK_USER_POINT_INDEX != 0 && !isLadderLine;
    }

}
