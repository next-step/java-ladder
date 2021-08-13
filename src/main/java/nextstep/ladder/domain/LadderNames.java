package nextstep.ladder.domain;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LadderNames {
    private static final String COMMA = ",";

    private final List<LadderName> ladderNames;

    private LadderNames(List<LadderName> ladderNames) {
        this.ladderNames = ladderNames;
    }

    public static LadderNames of(String ladderNames) {
        return new LadderNames(Arrays.stream(ladderNames.split(COMMA))
                                     .map(LadderName::of)
                                     .collect(toList()));
    }

    public List<String> getLadderNames() {
        return ladderNames.stream()
                          .map(LadderName::getLadderName)
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
        LadderNames that = (LadderNames) o;
        return Objects.equals(ladderNames, that.ladderNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderNames);
    }
}
