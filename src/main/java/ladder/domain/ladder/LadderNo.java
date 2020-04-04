package ladder.domain.ladder;

import java.util.Optional;

public class LadderNo {
    private int ladderNo;

    private LadderNo(int ladderNo) {
        this.ladderNo = ladderNo;
    }

    public static LadderNo of(int number) {
        return Optional.of(number)
                .filter(v -> v > 0)
                .map(LadderNo::new)
                .orElseThrow(() -> throwIllegalArgumentException(number));
    }

    private static IllegalArgumentException throwIllegalArgumentException(int number) {
        return new IllegalArgumentException(String.format("Create LadderNo failed. number must be positive : number=%d", number));
    }

    public int getLadderNo() {
        return ladderNo;
    }
}
