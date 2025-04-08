package laddergame.domain.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static laddergame.domain.user.Users.DELIMETER;

public class Names {
    private final List<Name> names = new ArrayList<>();

    public Names(String names) {
        List<String> stringNames = Arrays.asList(names.split(DELIMETER));
        for (String name: stringNames) {
            this.names.add(new Name(name));
        }
    }

    public Names(String[] names) {
        List<String> stringNames = Arrays.asList(names);
        for (String name: names) {
            this.names.add(new Name(name));
        }
    }

    public int size() {
        return names.size();
    }

    public List<Name> getNames() {
        return names;
    }
}
