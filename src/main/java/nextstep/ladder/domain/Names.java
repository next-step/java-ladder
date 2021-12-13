package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private static final int MINIMUM_ENTRY = 2;
    private static final String SEPARATORS = ",";

    private final List<Name> names;

    private Names(List<Name> names) {
        validNames(names);
        this.names = names;
    }

    public int entryMemberCount() {
        return names.size();
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }
    public static Names from(String name) {
        List<Name> names = Arrays.stream(name.split(SEPARATORS))
                .map(String::trim)
                .map(Name::new)
                .collect(Collectors.toList());
        return new Names(names);
    }

    private void validNames(List<Name> names) {
        if (names.size() < MINIMUM_ENTRY) {
            throw new IllegalArgumentException("참가자는 2명 이상이어야 합니다.");
        }
    }

}
