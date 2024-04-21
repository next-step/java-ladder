package nextstep.ladder.util;

import nextstep.ladder.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsoleUtil {
    private static final String VERTICAL_LINE = "|";
    private static final String MOVEABLE_FORMAT = "-----";
    private static final String LINE_BREAK = "\n";
    private static final String PRINT_FORMAT = "%6s";
    private static final String PLAYER_NAME_SPLIT_DELIMITER = ",";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<String> inputPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String input = SCANNER.nextLine(); // ex) pobi,honux,crong,jk
        return splitNames(input);

    }

    private static List<String> splitNames(String playerNames) {
        return Arrays.stream(playerNames.split(PLAYER_NAME_SPLIT_DELIMITER))
                .collect(Collectors.toList());
    }

    public static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return SCANNER.nextInt();
    }

    public static void printGameResults(LadderGame ladderGame) {
        System.out.println("실행결과");
        printPlayers(ladderGame.getPlayers());
        printLines(ladderGame.getLines());
    }

    private static void printPlayers(Players players) {
        String playerNames = IntStream.range(0, players.count())
                .mapToObj(players::getPlayer)
                .map(player -> String.format(PRINT_FORMAT, player.getName()))
                .collect(Collectors.joining());

        System.out.println(playerNames);
    }

    private static void printLines(Lines lines) {
        String linesString = IntStream.range(0, lines.getHeight())
                .mapToObj(targetHeight -> lineToString(lines.getLine(targetHeight)))
                .collect(Collectors.joining(LINE_BREAK));

        System.out.println(linesString);
    }

    private static String lineToString(Line line) {
        return IntStream.range(0, line.width())
                .mapToObj(index -> pointToString(line.getPoint(index)))
                .collect(Collectors.joining());
    }

    private static String pointToString(Point point) {
        if (point.canMoveLeft()) {
            return String.format(PRINT_FORMAT, MOVEABLE_FORMAT + VERTICAL_LINE);
        }

        return String.format(PRINT_FORMAT, VERTICAL_LINE);
    }
}
