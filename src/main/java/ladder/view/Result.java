package ladder.view;

import ladder.model.Line;
import ladder.model.Lines;
import ladder.model.Prize;
import ladder.model.User;
import ladder.model.Users;

import java.util.Optional;
import java.util.Scanner;

public class Result {
    private static Scanner scanner = new Scanner(System.in);

    private static final String NAME_FORMAT = "%5s ";
    private static final String PRIZE_FORMAT = "%5s ";
    private static final String RESULT_FORMAT = "%s : %s";
    private static final String LADDER_START_LINE = "    ";
    private static final String LADDER_END_LINE = "|";
    private static final String TRUE_TRUE_FALSE_LINE = "|-----|     ";
    private static final String TRUE_TRUE_LINE = "|-----";
    private static final String FALSE_LINE = "|     ";

    public static void printUsers(Users users) {
        for (User user : users.getParticipants()) {
            System.out.print( String.format(NAME_FORMAT, user.nameInfo()));
        }
        System.out.println();
    }

    public static void printLadder(Lines lines) {
        for (Line line : lines.getLineList()) {
            System.out.print(LADDER_START_LINE);
            checkPrintPoint(line);
            System.out.println(LADDER_END_LINE);
        }
    }

    public static void printPrize(Prize prize) {
        for (String prizeInfo : prize.prizeInfo()) {
            System.out.print(String.format(PRIZE_FORMAT, prizeInfo));
        }
        System.out.println();
    }

    public static void printResult(Users users) {
        System.out.println("결과를 보고 싶은 사람은?");
        String userName = scanner.nextLine();

        Optional userOptional = users.getParticipants()
                .stream()
                .filter(user -> user.nameInfo().equals(userName))
                .findAny();

        if (userOptional.isPresent()) {
            printResult(userOptional);
            return;
        }

        printResultAll(users);
    }

    private static void printResult(Optional userOptional) {
        User user = (User)userOptional.get();
        System.out.println(String.format(RESULT_FORMAT, user.nameInfo(), user.resultInfo()));
    }

    private static void printResultAll(Users users) {
        for (User user : users.getParticipants()) {
            System.out.println(String.format(RESULT_FORMAT, user.nameInfo(), user.resultInfo()));
        }
    }
    private static void checkPrintPoint(Line line) {
        for (int pointIndex=0; pointIndex < line.getPoints().size(); ) {
            pointIndex = printPoint(pointIndex, line);
        }
    }

    private static int printPoint(int pointIndex, Line line) {
        if (line.getPoints().get(pointIndex) && pointIndex < line.getPoints().size() - 2) {
            System.out.print(TRUE_TRUE_FALSE_LINE);
            return pointIndex += 2;
        }
        if (line.getPoints().get(pointIndex) && pointIndex < line.getPoints().size() - 1) {
            System.out.print(TRUE_TRUE_LINE);
        }
        if (!line.getPoints().get(pointIndex) && pointIndex < line.getPoints().size() - 1) {
            System.out.print(FALSE_LINE);
        }
        return ++pointIndex;
    }
}
