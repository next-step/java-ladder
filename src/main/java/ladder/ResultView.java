package ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultView {
    private static final String PARTICIPATE_PLAYERS_COUNT = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT = "최대 사다리 높이는 몇 개인가요?";

    private static final String RESULT = "실행결과";

    public static void playersCount() {
        System.out.println(PARTICIPATE_PLAYERS_COUNT);
    }

    public static void ladderHeight() {
        System.out.println(LADDER_HEIGHT);
    }

    public static void result(List<User> users, List<Line> ladder) {
        System.out.println(RESULT);
        printUserNames(users);
        printLadder(ladder);
    }

    private static void printUserNames(List<User> users) {
        System.out.println(
                users.stream()
                        .map(User::getName)
                        .collect(Collectors.joining(append(" "))));
    }

    private static void printLadder(List<Line> ladder) {
        for (Line line : ladder) {
            System.out.print("|");
            for (boolean connected : line.connections()) {
                String direction = connected ? "-" : " ";
                System.out.print(append(direction));
                System.out.print("|");
            }
            System.out.println();
        }
    }

    private static String append(String s) {
        StringBuffer sb = new StringBuffer();
        Stream.iterate(0, i -> i + 1)
                .limit(User.MAX_NAME_LENGTH)
                .forEach(x -> sb.append(s));
        return sb.toString();
    }
}
