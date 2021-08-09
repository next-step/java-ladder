package nextstep.ladder.domain;

import nextstep.ladder.exception.InputNullException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LadderNames {
    private static final String REPLACE_STRING =  "\\[|\\]";
    private static final String SPLIT_STRING = ",";
    private static final String TRANSFER_STRING = "";

    private List<LadderName> ladderNames;

    private LadderNames(List<LadderName> ladderNames) {
        this.ladderNames = ladderNames;
    }

    public static LadderNames of(List<LadderName> ladderNames) {
        return new LadderNames(ladderNames);
    }

    public static LadderNames of(String ladderNames) {
        inputValidation(ladderNames);
        return Arrays.stream(ladderNames.split(SPLIT_STRING))
                .map(LadderName::of)
                .collect(collectingAndThen(toList(), LadderNames::of));
    }

    private static void inputValidation(String ladderNames) {
        if (Objects.isNull(ladderNames) || ladderNames.isEmpty()) {
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
        return ladderNames.toString().replaceAll(REPLACE_STRING, TRANSFER_STRING);
    }
}
