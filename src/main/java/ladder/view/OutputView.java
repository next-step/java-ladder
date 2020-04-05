package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Players;

import java.util.stream.Collectors;

public class OutputView {

    private OutputView() {}

    public static void printPlayerName(Players players) {
        System.out.println("실행결과");
        System.out.println();
        players.getPlayers()
               .stream()
               .map(player -> formatName(player.getName()))
               .forEach(System.out::print);
        System.out.println();
    }

    public static void printLadder(final Ladder ladder) {
        ladder.getLines()
              .stream()
              .map(OutputView::printLine)
              .forEach(System.out::println);
    }

    private static String printLine(final Line line) {
        return line.getLine()
                   .stream()
                   .map(isLine -> isLine ? "-----" : "     ")
                   .collect(Collectors.joining("|", "", "|"));
    }

    // TODO : 테스트를 위한 public 접근 제한자, private로 수정할 것.
    public static String formatName(String name) {
        return String.format("%5s", name) + " ";
    }

}
