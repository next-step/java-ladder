package ladder.view;

import ladder.domain.game.Ladder;
import ladder.domain.game.Line;
import ladder.domain.game.Name;
import ladder.domain.game.Names;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

/**
 * Created By mand2 on 2020-12-07.
 */
public class ResultView {

    public static final String RESULT = "실행결과" + System.lineSeparator();

    public static final int NAME_SPACE = 5;
    public static final String BRIDGE_BLANK = " ";
    public static final String BRIDGE_CONNECTION = "-";
    public static final String BRIDGE_POLE = "|";

    public static void print(Names participants, Ladder ladder) {
        System.out.println(RESULT);
        printNames(participants.getNames());
        printLadder(ladder.getLadder());
    }

    private static void printNames(List<Name> names) {
        System.out.println(
                names.stream()
                .map(name -> String.format("%" + NAME_SPACE + "s", name))
                .collect(joining(BRIDGE_BLANK)));
    }

    private static void printLadder(List<Line> ladder) {
        ladder.stream()
                .forEach(line -> printLine(line.getLine()));
    }

    private static void printLine(List<Boolean> line) {
        line.forEach(hasConnected -> print(hasConnected));
        System.out.println();
    }

    private static void print(Boolean hasConnected) {
        System.out.print(printBridge(hasConnected));
        System.out.print(BRIDGE_POLE);
    }

    private static String printBridge(Boolean connected) {
        if (connected) {
            return repeat(BRIDGE_CONNECTION, NAME_SPACE);
        }
        return repeat(BRIDGE_BLANK, NAME_SPACE);
    }

    private static String repeat(String str, int times) {
        return IntStream.range(0, times).mapToObj(__ -> str).collect(joining());
    }


}
