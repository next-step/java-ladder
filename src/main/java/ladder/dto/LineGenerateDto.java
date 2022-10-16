package ladder.dto;

public class LineGenerateDto {
    private final int numOfUser;

    private final int ladderLength;

    public LineGenerateDto(int numOfUser, int ladderLength) {
        this.numOfUser = numOfUser;
        this.ladderLength = ladderLength;
    }

    public int getNumOfUser() {
        return numOfUser;
    }

    public int getLadderLength() {
        return ladderLength;
    }
}
