package nextstep.ladder.domain;

import nextstep.ladder.exception.LetterLimitException;

import java.util.Objects;

public class LadderName {
    private static final int LETTER_LIMIT = 5;
    private final String laddername;

    private LadderName(String ladderName) {
        this.laddername = ladderName;
    }

    public static LadderName of(String ladderName) {
        lengthValidation(ladderName);
        return new LadderName(ladderName);
    }

    private static void lengthValidation(String name) {
        if(name.length() > LETTER_LIMIT) {
            throw new LetterLimitException();
        }
    }

    public boolean findName(String name) {
        if(laddername.equals(name)) {
            return true;
        };
        return false;
    }

    public String getLaddername() {
        return laddername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderName that = (LadderName) o;
        return Objects.equals(laddername, that.laddername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(laddername);
    }

    @Override
    public String toString() {
        return laddername;
    }
}
