package nextstep.ladder.v2.view;

import nextstep.ladder.v2.model.Line;
import nextstep.ladder.v2.model.Player;
import nextstep.ladder.v2.model.Point;
import nextstep.ladder.v2.model.Prize;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private static final int MAX = 7;

    public static void printPlayers(List<Player> players) {
        StringBuilder sb = new StringBuilder();
        players.forEach(player -> sb.append(" ".repeat(getCountOfSpace(player.getName().length()))).append(player.getName()));
        System.out.println(sb);
    }

    private static int getCountOfSpace(int length) {
        return MAX - length;
    }

    public static void printResultLetters() {
        System.out.println();
        System.out.println("실행결과");
        System.out.println();
    }

    public static void printLadder(List<Line> lines) {
        StringBuilder sb = new StringBuilder();
        lines.forEach(line -> {
            sb.append(" ".repeat(MAX));
            List<Boolean> points = line.getPoints().stream().map(Point::isCurrent).collect(Collectors.toList());
            points.forEach(point -> sb.append("|").append(point ? "-".repeat(6) : " ".repeat(6)));
            sb.append("\n");
        });
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    public static void printPrizes(List<String> prizes) {
        StringBuilder sb = new StringBuilder();
        prizes.forEach(prize -> sb.append(" ".repeat(getCountOfSpace(prize))).append(prize));
        System.out.println(sb);
    }

    private static int getCountOfSpace(String input) {
        return input.length() > MAX ? input.length() : MAX - input.length();
    }

    public static void printResult(Map<Player, Prize> result) {
        if (result == null || result.isEmpty()) {
            throw new IllegalArgumentException("result is null or empty");
        }
        System.out.println();
        System.out.println("실행 결과");

        StringBuilder sb = new StringBuilder();
        if (result.size() == 1) {
            printOneResult(result, sb);
            return;
        }
        printAllResult(result, sb);
    }

    private static void printAllResult(Map<Player, Prize> result, StringBuilder sb) {
        result.forEach((key, value) -> sb.append(key.getName())
                .append(" : ")
                .append(value.getWorth())
                .append('\n'));
        System.out.println(sb);
    }

    private static void printOneResult(Map<Player, Prize> result, StringBuilder sb) {
        sb.append(result.values().stream()
                        .findFirst().
                        map(Prize::getWorth)
                        .orElseThrow(IllegalArgumentException::new))
                .append('\n');
        System.out.println(sb);
    }
}
