package nextstep.ladder.domain;

import nextstep.ladder.exception.NoSearchPersonException;
import nextstep.ladder.utils.Constants;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class Names {
    private final List<Name> ladderNames;

    private Names(List<Name> ladderNames) {
        this.ladderNames = ladderNames;
    }

    public static Names of(String ladderNames) {
        return new Names(Arrays.stream(ladderNames.split(Constants.COMMA))
                                     .map(Name::of)
                                     .collect(toList()));
    }

    public List<String> getLadderNames() {
        return ladderNames.stream()
                          .map(Name::getLadderName)
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
        Names that = (Names) o;
        return Objects.equals(ladderNames, that.ladderNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderNames);
    }
}
