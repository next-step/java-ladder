package nextstep.ladder.view;

import nextstep.ladder.domain.LadderGame;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;

import java.util.List;

public class DrawerView {

    public static final String LADDER_POLE = "|";
    public static final String LINE_BREAK = "\n";
    public static final String EMPTY = "     ";
    public static final String STEP = "-----";
    public static final String ALL_USERS_QUERY = "all";

    public void printLadderGameResult(List<String> names, List<Line> ladderInfo, List<String> winningResults) {
        System.out.println("실행 결과\n");

        printUserNames(names);
        printLadderInfo(ladderInfo);
        printWinningResult(winningResults);
        System.out.println();
    }

    private void printUserNames(List<String> names) {
        names.forEach(
                name -> System.out.printf("%6s", name)
        );
        System.out.println();
    }

    private void printLadderInfo(List<Line> ladderInfo) {
        StringBuffer stringBuffer = new StringBuffer();

        ladderInfo.forEach(
                line -> stringBuffer
                        .append(lineToString(line))
                        .append(LINE_BREAK)
        );
        System.out.println(stringBuffer);
    }

    private String lineToString(Line line) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer
                .append(EMPTY)
                .append(LADDER_POLE);

        List<Point> points = line.toList();
        for (int i = 1; i < points.size(); i++) {
            stringBuffer.append(getStepWithStepType(points.get(i - 1), points.get(i)));
        }

        return stringBuffer.toString();
    }

    private String getStepWithStepType(Point beforePoint, Point currentPoint) {
        if (beforePoint.isRight() && currentPoint.isLeft()) {
            return STEP + LADDER_POLE;
        }

        if (beforePoint.isLeft() && currentPoint.isStay()) {
            return EMPTY + LADDER_POLE;
        }

        if (beforePoint.isStay() && currentPoint.isRight()) {
            return EMPTY + LADDER_POLE;
        }

        if (beforePoint.isStay() && currentPoint.isStay()) {
            return EMPTY + LADDER_POLE;
        }

        return EMPTY + LADDER_POLE;
    }

    private void printWinningResult(List<String> winningResults) {
        winningResults.forEach(
                winningResult -> System.out.printf("%6s", winningResult)
        );
        System.out.println();
    }

    public void printWinningProductOfUser(String name, LadderGame ladderGame) {
        System.out.println(getWinningProductOfUser(name, ladderGame));
        System.out.println();
    }

    private String getWinningProductOfUser(String name, LadderGame ladderGame) {
        if (ALL_USERS_QUERY.equalsIgnoreCase(name)) {
            return getWinningProductOfAllUsers(ladderGame);
        }

        return ladderGame.getWinProduct(name);
    }

    private static String getWinningProductOfAllUsers(LadderGame ladderGame) {
        StringBuilder stringBuffer = new StringBuilder();

        List<String> participants = ladderGame.getParticipants();
        for (String participant : participants) {
            String winningProduct = ladderGame.getWinProduct(participant);
            stringBuffer.append(participant)
                    .append(" : ")
                    .append(winningProduct)
                    .append("\n");
        }

        return stringBuffer.toString();
    }
}
