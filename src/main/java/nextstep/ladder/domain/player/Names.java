package nextstep.ladder.domain.player;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Names {
    private final List<Name> values;

    public Names(String ... names) {
        checkSize(names);

        values = Stream.of(names)
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private void checkSize(String[] names) {
        if (names.length == 0) {
            throw new IllegalArgumentException("이름이 입력되지 않았습니다.");
        }
    }

    public boolean contains(Name name) {
        return values.contains(name);
    }

    public int size() {
        return values.size();
    }

    public List<Name> values() {
        return Collections.unmodifiableList(values);
    }
}
