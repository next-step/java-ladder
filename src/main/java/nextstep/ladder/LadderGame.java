package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {

    private static final String VERTICAL_LINE = "|";
    private static final String MOVEABLE_FORMAT = "-----";
    private static final String LINE_BREAK = "\n";
    private static final String PRINT_FORMAT = "%6s";
    private static final String PLAYER_NAME_SPLIT_DELIMITER = ",";

    public static void main(String[] args) {
        List<String> playerNames = inputPlayerNames();
        int countOfPerson = playerNames.size();
        int height = inputHeight();
        List<Line> lines = createLines(countOfPerson, height);

        printGameResults(playerNames, lines);
    }

    private static void printGameResults(List<String> players, List<Line> lines) {
        System.out.println("실행결과");
        printPlayers(players);
        printLines(lines);
    }

    private static void printPlayers(List<String> players) {
        String collect = players.stream()
                .map(name -> String.format(PRINT_FORMAT, name))
                .collect(Collectors.joining());

        System.out.println(collect);
    }

    private static void printLines(List<Line> lines) {
        String str = lines.stream()
                .map(LadderGame::lineToString)
                .collect(Collectors.joining(LINE_BREAK));

        System.out.println(str);
    }

    private static String lineToString(Line line) {
        return IntStream.range(0, line.size())
                .mapToObj(index -> pointToString(line.getPoint(index)))
                .collect(Collectors.joining());
    }

    private static String pointToString(Point point) {
        if (point.canMoveLeft()) {
            return String.format(PRINT_FORMAT, MOVEABLE_FORMAT + VERTICAL_LINE);
        }

        return String.format(PRINT_FORMAT, VERTICAL_LINE);
    }

    private static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return 5; // TODO: input
    }

    private static List<String> inputPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String input = "pobi,honux,crong,jk"; // TODO: input
        return Arrays.stream(input.split(PLAYER_NAME_SPLIT_DELIMITER))
                .collect(Collectors.toList());
    }

    private static List<Line> createLines(int countOfPerson, int height) {
        return IntStream.range(0, height)
                .mapToObj(i -> Line.createLine(countOfPerson))
                .collect(Collectors.toList());
    }
}
