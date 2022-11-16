package ladder.view;

import java.util.List;
import java.util.function.Consumer;

public class ResultDisplayer implements Displayer {
    private static final String BLANK = " ";

    private final List<String> results;
    private final int displaySize;

    public ResultDisplayer(final List<String> results, final int displaySize) {
        this.results = results;
        this.displaySize = displaySize;
    }

    @Override
    public void show(final Consumer<String> displayer) {
        StringBuilder display = new StringBuilder();
        for (String result : results) {
            display.append(result);
            display.append(blank(result.length()));
        }
        displayer.accept(display.toString());
    }

    private String blank(final int nameLength) {
        StringBuilder blank = new StringBuilder();
        blank.append(BLANK.repeat(Math.max(0, displaySize - nameLength + 1)));
        return blank.toString();
    }
}
