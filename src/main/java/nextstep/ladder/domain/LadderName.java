package nextstep.ladder.domain;

import java.util.Objects;
import nextstep.ladder.exception.LengthLimitException;
import nextstep.ladder.utils.Constants;

public class LadderName {


    private final String ladderName;

    private LadderName(String ladderName) {
        this.ladderName = ladderName;
    }

    public static LadderName of(String ladderName) {
        lengthValidate(ladderName);
        return new LadderName(ladderName);
    }

    private static void lengthValidate(String ladderName) {
        if (ladderName.length() > Constants.MAX_LENGTH) {
            throw new LengthLimitException("이름은 5글자를 넘을 수 없습니다.");
        }
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
        LadderName that = (LadderName) o;
        return Objects.equals(ladderName, that.ladderName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderName);
    }
}
