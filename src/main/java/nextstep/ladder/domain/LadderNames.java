package nextstep.ladder.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import nextstep.ladder.exception.InputNullException;
import nextstep.ladder.exception.LengthNotEqualException;
import nextstep.ladder.exception.NotExistPersonException;

public class LadderNames {
    private static final String REPLACE_STRING =  "\\[|\\]";
    private static final String SPLIT_STRING = ",";
    private static final String TRANSFER_STRING = "";

    private final List<LadderName> ladderNames;

    private LadderNames(List<LadderName> ladderNames) {
        this.ladderNames = ladderNames;
    }

    public static LadderNames of(List<LadderName> ladderNames) {
        Set<LadderName> ladderNameSet = new HashSet<>(ladderNames);

        lengthValidate(ladderNames.size(), ladderNameSet.size());

        return new LadderNames(ladderNames);
    }

    public static void lengthValidate(int ladderListSize, int ladderSetSize) {
        if(ladderListSize != ladderSetSize) {
            throw new LengthNotEqualException("이름은 중복이 될 수 없습니다.");
        }
    }

    public static LadderNames of(String ladderNames) {
        inputValidate(ladderNames);
        return Arrays.stream(ladderNames.split(SPLIT_STRING))
                .map(LadderName::of)
                .collect(collectingAndThen(toList(), LadderNames::of));
    }

    private static void inputValidate(String ladderNames) {
        if (Objects.isNull(ladderNames) || ladderNames.isEmpty()) {
            throw new InputNullException();
        }
    }

    public int size() {
        return ladderNames.size();
    }

    public String getLadderName(int index) {
        return ladderNames.get(index).getLaddername();
    }

    public int findIndex(String name) {
        return ladderNames.indexOf(ladderNames.stream()
                          .filter(ladderName -> ladderName.findName(name))
                          .findFirst()
                          .orElseThrow(NotExistPersonException::new));
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
