package ladder.view;

import ladder.domain.*;

import java.util.stream.IntStream;

public class ResultView {
    private final static String PRINT_LADDER_RESULT = "사다리 결과";
    private final static String PRINT_RESULT = "실행결과";
    public final static int AISLE_WIDTH = 6;

    public static void printLadder(Ladder ladder, LadderEdge ladderEdge) {
        System.out.println(PRINT_LADDER_RESULT);
        StringBuilder sb = new StringBuilder();
        sb.append(ladderEdge.getAllPlayer()).append(System.lineSeparator());
        ladder.getLayers().stream()
                .forEach(layer -> sb.append(printLayer(layer)));
        sb.append(ladderEdge.getAllReward()).append(System.lineSeparator());
        System.out.println(sb);
    }

    public static void printResult(String findResult, LadderGame ladderGame) {
        System.out.println(PRINT_RESULT);
        if (findResult.equals("all")) {
            printResultAll(ladderGame);
            return;
        }
        System.out.println(ladderGame.findReward(new Player(findResult)));
    }

    private static void printResultAll(LadderGame ladderGame) {
        ladderGame.gameResult()
                .keySet()
                .forEach(key -> System.out.println(
                        String.format("%s : %s", key, ladderGame.findReward(key))));
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
