package nextstep.ladder.view;

import nextstep.ladder.data.StepType;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;

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

        line.toList().forEach(
                step -> stringBuffer
                        .append(getStepWithStepType(step))
                        .append(LADDER_POLE)
        );
        return stringBuffer.toString();
    }

    private String getStepWithStepType(StepType stepType) {
        if (stepType == StepType.EMPTY) {
            return EMPTY;
        }

        return STEP;
    }

    private void printWinningResult(List<String> winningResults) {
        winningResults.forEach(
                winningResult -> System.out.printf("%6s", winningResult)
        );
        System.out.println();
    }

    public void printWinningProductOfUser(String name, Ladder ladder) {
        System.out.println(getWinningProductOfUser(name, ladder));
        System.out.println();
    }

    private String getWinningProductOfUser(String name, Ladder ladder) {
        if (ALL_USERS_QUERY.equalsIgnoreCase(name)) {
            return getWinningProductOfAllUsers(ladder);
        }

        return ladder.getUserProducts(name);
    }

    private static String getWinningProductOfAllUsers(Ladder ladder) {
        StringBuilder stringBuffer = new StringBuilder();

        List<String> participants = ladder.getParticipants();
        for (String participant : participants) {
            String winningProduct = ladder.getUserProducts(participant);
            stringBuffer.append(participant)
                    .append(" : ")
                    .append(winningProduct)
                    .append("\n");
        }

        return stringBuffer.toString();
    }
}
