package ladder.domain.ladder;

import java.util.Objects;
import java.util.Optional;

public class LadderNumber {
    private static final String INSTANTIATE_ERROR_FORMAT = "Create LadderNo failed. number must be at least %d : number=%d";
    private static final int MINIMUM_NUMBER = 0;
    private int ladderNo;

    private LadderNumber(int ladderNo) {
        this.ladderNo = ladderNo;
    }

    public static LadderNumber of(int number) {
        return Optional.of(number)
                .filter(v -> v >= MINIMUM_NUMBER)
                .map(LadderNumber::new)
                .orElseThrow(() -> throwIllegalArgumentException(number));
    }

    private static IllegalArgumentException throwIllegalArgumentException(int number) {
        return new IllegalArgumentException(String.format(INSTANTIATE_ERROR_FORMAT, MINIMUM_NUMBER, number));
    }

    public int getLadderNo() {
        return ladderNo;
    }

    @Override
    public String toString() {
        return "LadderNo{" +
                "ladderNo=" + ladderNo +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderNumber ladderNumber1 = (LadderNumber) o;
        return ladderNo == ladderNumber1.ladderNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderNo);
    }
}
