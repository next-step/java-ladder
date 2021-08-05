package nextstep.ladder.domain;

import nextstep.ladder.exception.InputNullException;

import java.util.List;
import java.util.Objects;

public class LadderNames {

    private List<LadderName> ladderNames;

    public static LadderNames make(String ladderName) {
        return new LadderNames(ladderName);
    }

    private LadderNames(final String ladderNames) {
        this.inputValidation(ladderNames);
        this.ladderNames = LadderName.of(ladderNames);
    }

    private void inputValidation(String ladderNames) {
        if (Objects.isNull(ladderNames) || ladderNames.equals("")) {
            throw new InputNullException();
        }
    }

    public int size() {
        return this.ladderNames.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderNames that = (LadderNames) o;
        return Objects.equals(ladderNames, that.ladderNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderNames);
    }

    @Override
    public String toString() {
        return ladderNames.toString();
    }
}
