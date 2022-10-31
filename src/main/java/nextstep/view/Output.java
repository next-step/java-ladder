package nextstep.view;

import nextstep.domain.Ladder;
import nextstep.domain.Line;
import nextstep.domain.Player;

import java.util.List;
import java.util.stream.Collectors;

public class Output {
    public static void printName(List<Player> players) {
        StringBuilder sb = new StringBuilder();

        String result = players.stream()
                .map(Player::getName)
                .collect(Collectors.joining("  "));

        sb.append(String.format("\n실행결과\n %s", result));
        System.out.println(sb);
    }

    public static void printLadder(Ladder ladder) {
        StringBuilder sb = new StringBuilder();

        ladder.getLines().stream()
                .forEachOrdered(line -> getLine(sb, line));

        System.out.println(sb);
    }

    private static void getLine(StringBuilder sb, Line line) {
        sb.append("    ");
        sb.append("|");
        line.getPoints().stream()
                .forEachOrdered(idx -> sb.append(print(idx)).append("|"));
        sb.append("\n");
    }

    private static String print(Boolean idx) {
        if (idx == true) {
            return "-----";
        }
        return "     ";
    }
}
