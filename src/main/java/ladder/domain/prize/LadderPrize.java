package ladder.domain.prize;

import java.util.Objects;
import ladder.exception.InvalidPrizeNameException;
import ladder.utils.StringUtils;

public class LadderPrize {

    private final String prize;

    private LadderPrize(String prize) {
        validate(prize);
        this.prize = prize;
    }

    public static LadderPrize of(String prize) {
        return new LadderPrize(prize);
    }

    public String getPrize() {
        return prize;
    }

    private void validate(String prize) {
        if (StringUtils.isNullOrBlank(prize)) {
            throw new InvalidPrizeNameException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LadderPrize)) {
            return false;
        }
        LadderPrize that = (LadderPrize) o;
        return Objects.equals(getPrize(), that.getPrize());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrize());
    }

    @Override
    public String toString() {
        return "LadderPrize{" +
                "prize='" + prize + '\'' +
                '}';
    }
}
