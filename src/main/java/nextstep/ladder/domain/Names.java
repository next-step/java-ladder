package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static nextstep.ladder.util.StringSplit.stringSplitToList;

public class Names {

    private final List<Name> values = new ArrayList<>();

    public Names(String names) {
        Arrays.stream(stringSplitToList(names))
                .forEach(name -> this.values.add(new Name(name)));
    }

    public List<Name> values() {
        return Collections.unmodifiableList(values);
    }

    public int size() {
        return values.size();
    }

    public Name get(int i) {
        return values.get(i);
    }
}
