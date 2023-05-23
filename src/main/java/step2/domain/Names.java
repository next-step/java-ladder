package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private final List<Name> names;

    public Names(List<String> names) {
        validateNames(names);
        this.names = names.stream().map(Name::new).collect(Collectors.toList());
    }

    private void validateNames(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException("게임을 실행하려면 사람이 적어도 2명은 있어야 합니다.");
        }
    }

    public List<Name> getNames() {
        return names;
    }
}
