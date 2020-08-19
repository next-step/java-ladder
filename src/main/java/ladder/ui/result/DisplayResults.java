package ladder.ui.result;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class DisplayResults implements DisplayResult {
    private final List<? extends DisplayResult> displayResults;

    public DisplayResults(List<? extends DisplayResult> displayResults) {
        this.displayResults = Collections.unmodifiableList(displayResults);
    }

    @Override
    public String toDisplay() {
        return displayResults.stream()
                             .map(DisplayResult::toDisplay)
                             .collect(joining("\n"));
    }
}
