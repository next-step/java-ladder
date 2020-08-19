package ladder.ui.result;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NamesDisplayResult implements DisplayResult{
    private final List<String> names;

    public NamesDisplayResult(List<String> names) {
        this.names = Collections.unmodifiableList(names);
    }

    @Override
    public String toDisplay() {
        return names.stream()
                    .map(n -> String.format("%6s",n))
                    .collect(Collectors.joining(""));
    }
}
