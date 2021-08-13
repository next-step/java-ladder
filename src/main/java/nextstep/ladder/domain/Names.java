package nextstep.ladder.domain;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Names {
    private static final String COMMA = ",";

    private final List<Name> ladderNames;

    private Names(List<Name> ladderNames) {
        this.ladderNames = ladderNames;
    }

    public static Names of(String ladderNames) {
        return new Names(Arrays.stream(ladderNames.split(COMMA))
                                     .map(Name::of)
                                     .collect(toList()));
    }

    public List<String> getLadderNames() {
        return ladderNames.stream()
                          .map(Name::getLadderName)
                          .collect(toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Names that = (Names) o;
        return Objects.equals(ladderNames, that.ladderNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderNames);
    }
}
