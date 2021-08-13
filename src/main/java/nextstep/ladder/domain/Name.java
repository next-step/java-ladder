package nextstep.ladder.domain;

import java.util.Objects;
import nextstep.ladder.exception.LengthLimitException;

public class Name {
    private static final int MAX_LENGTH = 5;
    private static final String SPACE = " ";

    private final String ladderName;

    private Name(String ladderName) {
        this.ladderName = ladderName;
    }

    public static Name of(String ladderName) {
        lengthValidate(ladderName);
        return new Name(addSpace(ladderName));
    }

    private static void lengthValidate(String ladderName) {
        if (ladderName.length() > MAX_LENGTH) {
            throw new LengthLimitException("이름은 5글자를 넘을 수 없습니다.");
        }
    }

    private static String addSpace(String ladderName) {
        if (ladderName.length() >= MAX_LENGTH) {
            return ladderName;
        }
        return addSpace(SPACE.concat(ladderName));
    }

    public String getLadderName() {
        return ladderName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name that = (Name) o;
        return Objects.equals(ladderName, that.ladderName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderName);
    }
}
