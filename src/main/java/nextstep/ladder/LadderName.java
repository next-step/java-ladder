package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LadderName {
    private List<String> ladderNames;

    public LadderName(final String ladderNames) {
        this.ladderNames = Arrays.stream(ladderNames.split(","))
                           .map(this::lengthValidation)
                           .collect(Collectors.toList());
    }

    private String lengthValidation(String name) {
        if(name.length() > 5) {
            throw new StringLengthException();
        }
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderName that = (LadderName) o;
        return Objects.equals(ladderNames, that.ladderNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderNames);
    }
}
