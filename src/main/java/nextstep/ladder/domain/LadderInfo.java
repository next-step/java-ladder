package nextstep.ladder.domain;

import nextstep.ladder.exceptions.OutOfLadderSizeException;

public class LadderInfo {

    private final Lines lines;

    public LadderInfo(int height, int numberOfParticipants) {
        this.lines = new Lines(height, numberOfParticipants);
    }

    public boolean lines(int row, int column) {
        if (row < 0
                || row >= this.lines.height()
                || column < 0
                || column >= this.lines.numberOfParticipants() - 1) {
            throw new OutOfLadderSizeException("사다리 범위를 넘는 값 조회입니다.");
        }
        return this.lines.value().get(row).points().get(column).linked();
    }

    public Lines lines() {
        return this.lines;
    }
}
