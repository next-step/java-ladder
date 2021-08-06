package nextstep.ladder.domain;

import nextstep.ladder.exception.InputNullException;
import nextstep.ladder.exception.StringLengthException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LadderNames {
    private static final int LETTER_LIMIT = 5;

    private List<LadderName> ladderNames;

    public static LadderNames make(String ladderName) {
        return new LadderNames(ladderName);
    }

    private LadderNames(final String ladderNames) {
        inputValidation(ladderNames);
        List<LadderName> list = new ArrayList<>();
        Arrays.stream(ladderNames.split(","))
                .map(this::lengthValidation)
                .forEach(name -> list.add(new LadderName(name)));
        this.ladderNames = list;
    }

    private void inputValidation(String ladderNames) {
        if (Objects.isNull(ladderNames) || ladderNames.equals("")) {
            throw new InputNullException();
        }
    }

    private String lengthValidation(String name) {
        if(name.length() > LETTER_LIMIT) {
            throw new StringLengthException();
        }
        return name;
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
        return ladderNames.toString().replaceAll("\\[|\\]", "");
    }
}
