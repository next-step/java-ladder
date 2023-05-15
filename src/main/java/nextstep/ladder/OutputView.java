package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String SPACE = " ";
    private static final int MAX_NAME_LENGTH = 5;
    public static final String FRONT_SPACE = "    ";
    public static final String BRIDGE_NOT_EXISTS = "     ";
    public static final String BRIDGE_EXISTS = "-----";
    public static final String LADDER_BAR = "|";

    public static void printParticipantsMessage() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
    }

    public static void printAskLadderHeightMessage() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public static void printLadder(List<String> participantsName, List<Line> ladderLines) {
        System.out.println("실행결과\n");
        participantsName.forEach(name -> System.out.print(nameFormat(name)));

        System.out.println();
        printLadder(ladderLines);
    }

    private static String nameFormat(String name) {
        return SPACE.repeat(MAX_NAME_LENGTH - name.length()) + name + SPACE;
    }

    private static void printLadder(List<Line> ladder) {
        for (Line line : ladder) {
            System.out.println(FRONT_SPACE + drawLine(line));
        }
    }

    private static String drawLine(Line line) {
        return line.getPoints().stream()
                .map(i -> i ? BRIDGE_EXISTS : BRIDGE_NOT_EXISTS)
                .collect(Collectors.joining(LADDER_BAR, LADDER_BAR, LADDER_BAR));
    }
}
