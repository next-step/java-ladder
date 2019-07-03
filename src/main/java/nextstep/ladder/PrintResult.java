package nextstep.ladder;

import java.util.List;
import java.util.StringJoiner;

public class PrintResult {
    private static final int WIDTH = 5;

    public static void printUsers(List<User> users) {
        users.stream()
                .forEach(user -> System.out.print(String.format("%5s ", user.getUserName())));

    }

    public static void println() {
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {

        String whiteSpace = StringUtil.repeat("", WIDTH);
        String bar = "|";
        String dash = StringUtil.repeat("-", WIDTH);

        ladder.getLines()
                .stream()
                .map(line -> line.getPoints())
                .forEach(points -> {
                    StringJoiner sj = new StringJoiner(bar, whiteSpace + "|", bar);
                    points.stream().forEach(point -> {
                        if (point) {
                            sj.add(dash);
                        } else {
                            sj.add(whiteSpace);
                        }
                    });
                    System.out.println(sj.toString());
                });

    }
}
