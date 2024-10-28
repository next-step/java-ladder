package ladder;

import java.util.Objects;

public class LadderCount {

    private int ladderCount;

    public LadderCount(String ladderCount) {
        validForLadderCount(ladderCount);
    }

    private void validForLadderCount(String ladderCount) {

        if (ladderCount.isBlank()) {
            throw new IllegalArgumentException("사다리 높이가 입력되지 않았습니다.");
        }

        int ladderCountForInteger = 0;

        try {
            ladderCountForInteger = Integer.parseInt(ladderCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("사다리 수는 유효한 정수여야 합니다.");
        }

        if (ladderCountForInteger <= 0) {
            throw new IllegalArgumentException("사다리 수는 양의 정수여야 합니다.");
        }

        this.ladderCount = ladderCountForInteger;
    }

    public int getLadderCount() {
        return ladderCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderCount that = (LadderCount) o;
        return ladderCount == that.ladderCount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ladderCount);
    }
}
