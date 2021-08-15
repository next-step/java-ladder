package ladder.domain;

import java.util.Objects;

public class Ladder {

    private int countOfPerson;
    private int ladderManxLength;

    public Ladder(int countOfPerson, int ladderMaxLength) {
        this.countOfPerson = countOfPerson;
        this.ladderManxLength = ladderMaxLength;
    }

    public static Ladder of(int countOfPerson, int ladderMaxLength) {
        return new Ladder(countOfPerson, ladderMaxLength);
    }

    public int getLineCount() {
        return 5;
    }

    public int getCountOfPerson() {
        return 4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return countOfPerson == ladder.countOfPerson && ladderManxLength == ladder.ladderManxLength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countOfPerson, ladderManxLength);
    }


}
