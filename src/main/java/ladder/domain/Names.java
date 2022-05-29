package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Names {
    private final List<Name> names;

    private Names(List<String> names) {
        this.names = new ArrayList<>();
        names.stream().forEachOrdered(name -> this.names.add(Name.of(name)));
    }
    
    public static Names of(List<String> names) {
        return new Names(names);
    }
}
