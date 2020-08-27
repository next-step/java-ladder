package ladder.ui.result;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import ladder.domain.core.line.name.Names;

public class NamesDisplayResult implements DisplayResult{
    private final List<String> names;

    public NamesDisplayResult(Names name) {
        this.names = Collections.unmodifiableList(name.getPrimitiveNames());
    }

    @Override
    public String toDisplay() {
        return names.stream()
                    .map(n -> String.format("%6s",n))
                    .collect(Collectors.joining(""));
    }
}
