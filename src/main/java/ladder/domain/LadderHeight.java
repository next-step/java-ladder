package ladder.domain;

import java.util.Objects;

public class LadderHeight {
    private int ladderHeigth;

    public LadderHeight(int ladderHeigth) {
        this.ladderHeigth = ladderHeigth;
    }

    public int getLadderHeigth() {
        return ladderHeigth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderHeight that = (LadderHeight) o;
        return ladderHeigth == that.ladderHeigth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderHeigth);
    }
}
