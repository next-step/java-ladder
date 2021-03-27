package ladder;

import java.util.List;
import java.util.stream.Collectors;

public class InputManagement {

    private final List<Name> names;
    private final int height;

    public InputManagement(List<String> names, int height) {
        this.names = names.stream()
                .map(Name::new)
                .collect(Collectors.toList());
        this.height = height;
    }

    public List<Name> getNames() {
        return names;
    }

    public int getHeight() {
        return height;
    }
}
