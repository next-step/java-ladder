package ladder.view;

import ladder.model.Layer;

import java.util.stream.Collectors;

public class OutputView {

    private static String RUNG = "-----|";
    private static String EMPTY_RUNG = "     |";

    public static void print(Layer layer) {
        String line = layer.getRungs().stream().map(rung -> rung.isRung() ? RUNG : EMPTY_RUNG).collect(Collectors.joining());
        System.out.println(EMPTY_RUNG.concat(line));
    }
}
