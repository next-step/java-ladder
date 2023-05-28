package step4.view;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private final List<Name> names;

    public Names(List<String> names) {
        validateNames(names);
        this.names = names.stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private static void validateNames(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException("게임을 실행하려면 사람이 적어도 2명은 있어야 합니다.");
        }
    }

    public int size() {
        return names.size();
    }

    public int indexOf(Name name) {
        return names.indexOf(name);
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }
}