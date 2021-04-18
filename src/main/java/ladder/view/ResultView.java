package ladder.view;

import ladder.domain.GameHelper;
import ladder.domain.Ladder;
import ladder.domain.Layer;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class ResultView {
    private final static String PRINT_LADDER_RESULT = "사다리 결과";
    private final static String PRINT_RESULT = "실행결과";
    private final static int AISLE_WIDTH = 6;

    public static void printLadder(Ladder ladder, GameHelper gameHelper) {
        System.out.println(PRINT_LADDER_RESULT);
        StringBuilder sb = new StringBuilder();
        sb.append(printEdge(gameHelper.getTop()));
        ladder.getLayers().stream()
                .forEach(layer -> sb.append(printLayer(layer)));
        sb.append(printEdge(gameHelper.getBottom()));
        System.out.println(sb);
    }

    public static void printResult(String findResult, Map<String, String> gameResult) {
        System.out.println(PRINT_RESULT);
        if (findResult.equals("all")) {
            printResultAll(gameResult);
            return;
        }
        System.out.println(gameResult.get(findResult));
    }

    private static void printResultAll(Map<String, String> gameResult) {
        gameResult.keySet()
                .forEach(key -> System.out.println(
                        String.format("%s : %s", key, gameResult.get(key))));
    }

    private static String printEdge(List<String> edge) {
        StringBuilder sb = new StringBuilder();
        edge.stream()
                .forEach(s -> sb.append(s).append(printWhiteSpace(s)));
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    private static String printWhiteSpace(String user) {
        if (user.length() > AISLE_WIDTH + 1) {
            return "";
        }
        int nullSpace = AISLE_WIDTH + 1 - user.length();
        StringBuilder sb = new StringBuilder();
        IntStream.rangeClosed(0, nullSpace)
                .forEach(i -> sb.append(" "));
        return sb.toString();
    }

    private static String printLayer(Layer layer) {
        StringBuilder sb = new StringBuilder();
        layer.getAisles().stream()
                .forEach(aisle -> sb.append("|").append(printAisle(aisle)));
        sb.append("|").append(System.lineSeparator());
        return sb.toString();
    }

    private static String printAisle(boolean aisle) {
        StringBuilder sb = new StringBuilder();

        if (aisle) {
            IntStream.rangeClosed(0, AISLE_WIDTH)
                    .forEach(i -> sb.append("-"));
            return sb.toString();
        }
        IntStream.rangeClosed(0, AISLE_WIDTH)
                .forEach(i -> sb.append(" "));
        return sb.toString();
    }


}
