package nextstep.view;

import nextstep.domain.*;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Output {

    private static final String SPACE_BETWEEN_NAMES = "   ";
    private static final String SPACE_BETWEEN_RESULTS = "    ";
    private static final String RESULT_MESSAGE = "\n실행결과\n%s";
    private static final String EMPTY_LINE = "     |";
    private static final String HORIZONTAL_LINE = "-----|";
    private static final String DELIMITER = " : ";
    private static final String INPUT_PERSON_MESSAGE = "결과를 보고 싶은 사람은?";
    private static final Scanner sc = new Scanner(System.in);
    private static StringBuilder sb = new StringBuilder();

    public static void printName(List<Player> players) {

        sb.setLength(0);

        String result = players.stream()
                .map(Player::getName)
                .collect(Collectors.joining(SPACE_BETWEEN_NAMES));

        sb.append(String.format(RESULT_MESSAGE, result));
        System.out.println(sb);
    }

    public static void printLadder(Ladder ladder) {
        sb.setLength(0);

        ladder.getLines().stream()
                .forEachOrdered(line -> getLine(sb, line));

        System.out.print(sb);
    }

    public static void printResult(Result result) {
        sb.setLength(0);

        String getResult = result.stream()
                .collect(Collectors.joining(SPACE_BETWEEN_RESULTS));

        sb.append(getResult);
        System.out.println(sb);
        System.out.println();
    }

    private static void getLine(StringBuilder sb, Line line) {
        line.getPoints().stream()
                .forEachOrdered(point -> sb.append(print(point)));
        sb.append("\n");
    }

    private static String print(Point point) {
        if (point.isPoint()) {
            return HORIZONTAL_LINE;
        }
        return EMPTY_LINE;
    }

    public static void printResult(Players players, Result result, Ladder ladder) {
        while (true) {
            System.out.println(INPUT_PERSON_MESSAGE);
            String player = sc.nextLine();

            compareAllPlayers(players, result, ladder, player);
            printPlayerResult(players, result, ladder, player);
        }
    }

    private static void compareAllPlayers(Players players, Result result, Ladder ladder, String player) {
        if (player.equals("all")) {
            printAllPlayersResult(players, result, ladder);
        }
    }

    public static void printAllPlayersResult(Players players, Result result, Ladder ladder) {
        System.out.println(RESULT_MESSAGE);
        sb.setLength(0);

        int idx = 0;
        for (Player player : players.getPlayers()) {
            int moveIdx = ladder.move(idx);
            sb.append(player.getName())
                    .append(DELIMITER)
                    .append(result.get(moveIdx))
                    .append(System.lineSeparator());
            idx++;
        }

        System.out.println(sb);
    }

    public static void printPlayerResult(Players players, Result result, Ladder ladder, String player) {
        System.out.println(RESULT_MESSAGE);
        sb.setLength(0);

        for (int i = 0; i < players.getPlayersSize(); i++) {
            int idx = ladder.move(i);
            if (players.getPlayers().get(i).getName().equals(player)) {
                sb.append(result.get(idx)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
