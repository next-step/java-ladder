package ladder.domain.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Participants {

    private final List<Name> names = new ArrayList<>();

    public Participants(String names) {
        String[] split = names.split(",");
        for (String name : split) {
            this.names.add(new Name(name));
        }
    }

    public List<Name> get() {
        return Collections.unmodifiableList(names);
    }

    public int size() {
        return names.size();
    }
}
