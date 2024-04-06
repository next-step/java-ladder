package nextstep.ladder;

import nextstep.ladder.domain.*;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGameApplication {

    private static final String VERTICAL_LINE = "|";
    private static final String MOVEABLE_FORMAT = "-----";
    private static final String LINE_BREAK = "\n";
    private static final String PRINT_FORMAT = "%6s";

    public static void main(String[] args) {
        String playerNames = inputPlayerNames();
        int height = inputHeight();

        LadderGame ladderGame = LadderGame.of(playerNames, height);

        printGameResults(ladderGame);
    }

    private static void printGameResults(LadderGame ladderGame) {
        System.out.println("실행결과");
        printPlayers(ladderGame.getPlayers());
        printLines(ladderGame.getLines());
    }

    private static void printPlayers(Players players) {
        String playerNames = IntStream.range(0, players.countOfPerson())
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

    private static String inputPlayerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        return "pobi,honux,crong,jk"; // TODO: input
    }
}
