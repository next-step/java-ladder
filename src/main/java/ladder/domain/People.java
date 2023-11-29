package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class People {
    private final List<Name> names;

    public People(List<String> nameList) {
        this.names = nameList.stream().map(Name::new).collect(Collectors.toList());
    }

    public int count() {
        return names.size();
    }

    public List<Name> values() {
        return Collections.unmodifiableList(names);
    }

    public int indexOf(Name name) {
        return names.indexOf(name);
    }

    public boolean contains(Name name) {
        return names.contains(name);
    }

}
