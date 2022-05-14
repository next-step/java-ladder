package nextstep.view;

import nextstep.domain.LadderLine;
import nextstep.domain.StartLadderGame;
import nextstep.domain.User;

import java.util.List;
import java.util.stream.IntStream;


public class ResultView {
    private static final String PAD = "     ";
    private static final String LPAD = "      ";
    private static final String USER_POINT = "|";
    private static final String LADDER_LINE = "-";
    private static final String BLANK = " ";
    private static final int CHECK_USER_POINT_INDEX = 6;

    public static void print(StartLadderGame startLadderGame) {
        System.out.println("실행결과\n");
        printUserList(startLadderGame.getUsers());
        System.out.println();
        printLadderLines(startLadderGame.getUsers().get(0).getUserName().length()
                , startLadderGame.getLadder().getLadderLines());
    }

    private static void printUserList(List<User> users) {
        System.out.print(users.get(0).getUserName()
                + PAD.substring(users.get(0).getUserName().length()));
        for (int i = 1; i < users.size(); i++) {
            System.out.print(LPAD.substring(users.get(i).getUserName().length())
                    + users.get(i).getUserName());
        }
    }

    private static void printLadderLines(int firstUserNameLength, List<LadderLine> ladderLines) {
        IntStream.range(0, ladderLines.size())
                .forEach(i -> {
                    System.out.print(PAD.substring(0, firstUserNameLength));
                    printLAdderLine(ladderLines.get(i));
                    System.out.println();
                });
    }

    private static void printLAdderLine(LadderLine ladderLine) {
        IntStream.range(0, ladderLine.getPoints().size())
                .forEach(i -> {
                    if (isUserPoint(i)) {
                        System.out.print(USER_POINT);
                    }
                    if (isLadderLine(i, ladderLine.getPoints().get(i))) {
                        System.out.print(LADDER_LINE);
                    }
                    if (isLadderBlankLine(i, ladderLine.getPoints().get(i))) {
                        System.out.print(BLANK);
                    }
                });
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
