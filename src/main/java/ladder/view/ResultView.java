package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Layer;

import java.util.List;

public class ResultView {
    private final static String PRINT_RESULT = "실행결과";

    public static void printLadder(Ladder ladder, List<String> users) {
        StringBuilder sb = new StringBuilder();
        sb.append(printUsers(users));
        ladder.stream()
                .forEach(layer -> sb.append(printLayer(layer)));
        System.out.println(sb.toString());
    }

    private static String printUsers(List<String> users) {
        StringBuilder sb = new StringBuilder();
        users.stream()
                .forEach(user -> sb.append(user).append("  "));
        sb.append(System.lineSeparator());
        return sb.toString();
    }

    private static String printLayer(Layer layer) {
        StringBuilder sb = new StringBuilder();
        layer.stream()
                .forEach(aisle -> sb.append("|").append(printAisle(aisle)));
        sb.append("|").append(System.lineSeparator());
        return sb.toString();
    }

    private static String printAisle(boolean aisle) {
        if (aisle) {
            return "-----";
        }
        return "     ";
    }


}
