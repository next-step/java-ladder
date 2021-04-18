package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.Layer;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
    private final static String PRINT_RESULT = "실행결과";
    private final static int AISLE_WIDTH = 6;

    public static void printLadder(Ladder ladder, List<String> users) {
        StringBuilder sb = new StringBuilder();
        sb.append(printUsers(users));
        ladder.getLayers().stream()
                .forEach(layer -> sb.append(printLayer(layer)));
        System.out.println(sb);
    }

    private static String printUsers(List<String> users) {
        StringBuilder sb = new StringBuilder();
        users.stream()
                .forEach(user -> sb.append(user).append(printWhiteSpace(user)));
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
