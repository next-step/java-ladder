package nextstep.ladder;

import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private static final int MIN_SIZE = 2;
    private final List<Name> names;

    public static Names of(List<String> names) {
        List<Name> mapped = names.stream()
                .map(Name::new)
                .collect(Collectors.toList());
        return new Names(mapped);
    }

    private Names(List<Name> names) {
        if (names.size() < MIN_SIZE) {
            throw new IllegalArgumentException("참여 인원이 너무 적습니다.");
        }
        this.names = names;
    }

    public int count() {
        return names.size();
    }

    public List<Name> getNames() {
        return names;
    }
}
