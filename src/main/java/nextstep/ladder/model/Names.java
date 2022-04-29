package nextstep.ladder.model;

import nextstep.common.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Names {

    private static final String DEFAULT_DELIMITER = ",";

    private final List<Name> names;

    private Names(List<Name> names) {
        Assert.notEmpty(names, "names must not be empty");
        this.names = new ArrayList<>(names);
    }

    public static Names from(String namesString) {
        Assert.hasText(namesString, "names must not be blank");
        return new Names(Arrays.stream(namesString.split(DEFAULT_DELIMITER))
                .map(Name::from)
                .collect(Collectors.toList())
        );
    }

    public int size() {
        return names.size();
    }

    public List<Name> list() {
        return Collections.unmodifiableList(names);
    }
}
