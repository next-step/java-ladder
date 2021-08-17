package nextstep.ladder.domain;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import nextstep.ladder.exception.NoSearchPersonException;
import nextstep.ladder.utils.Constants;

public class LadderNames {
    private final List<LadderName> ladderNames;

    private LadderNames(List<LadderName> ladderNames) {
        this.ladderNames = ladderNames;
    }

    public static LadderNames of(String ladderNames) {
        return new LadderNames(Arrays.stream(ladderNames.split(Constants.COMMA))
                                     .map(LadderName::of)
                                     .collect(toList()));
    }

    public List<String> getLadderNames() {
        return ladderNames.stream()
                          .map(LadderName::getLadderName)
                          .collect(toList());
    }

    public int findName(String inputName) {
        searchValidate(inputName);
        return getLadderNames().indexOf(inputName);
    }

    private void searchValidate(String inputName) {
        if(!getLadderNames().contains(inputName)) {
            throw new NoSearchPersonException("해당하는 사람 없음");
        }
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
