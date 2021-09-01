package newladder.view;

import newladder.model.Direction;
import newladder.model.GameResult;
import newladder.model.Prize;
import newladder.model.MyLadder;
import newladder.model.MyLine;
import newladder.model.User;
import newladder.model.Users;

import java.util.HashMap;
import java.util.Scanner;

public class Result {
    private static Scanner scanner = new Scanner(System.in);

    private static final String NAME_FORMAT = "%5s ";
    private static final String PRIZE_FORMAT = "%5s ";
    private static final String RESULT_MESSAGE = "실행결과";
    private static final String RESULT_FORMAT = "%s : %s";
    private static final String LADDER_START_LINE = "    ";
    private static final String TRUE_LINE = "|-----";
    private static final String FALSE_LINE = "|     ";

    public static void printUsers(Users users) {
        for (User user : users.usersInfo()) {
            System.out.print( String.format(NAME_FORMAT, user.nameInfo()));
        }
        System.out.println();
    }

    public static void printLadder(MyLadder ladder) {
        for (MyLine line : ladder.lineInfo()) {
            System.out.print(LADDER_START_LINE);
            checkPrintPoint(line);
            System.out.println();
        }
    }

    public static void printPrize(Prize prize) {
        for (String prizeInfo : prize.prizeInfo()) {
            System.out.print(String.format(PRIZE_FORMAT, prizeInfo));
        }
        System.out.println();
    }

    public static void printResult(String prizeInfo) {
        System.out.println(RESULT_MESSAGE);
        System.out.println(prizeInfo);
    }


    public static void printResultAll(GameResult gameResult) {
        System.out.println(RESULT_MESSAGE);
        for (String userName : gameResult.getResult().keySet()) {
            System.out.println(String.format(RESULT_FORMAT, userName, gameResult.getResult(userName)));
        }
        System.out.println();
    }
    private static void checkPrintPoint(MyLine line) {
        for (Direction direction : line.directionInfo()) {
            printPoint(direction.printPoint());
        }
    }

    private static void printPoint(boolean printRight) {
        if (printRight) {
            System.out.print(TRUE_LINE);
            return;
        }
        System.out.print(FALSE_LINE);
    }
}
