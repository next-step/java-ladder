package nextstep.ladder.domain;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-06-29 03:27
 */
public class Ladder {
    private static final int MIN_LADDER_HEIGHT = 3;
    private final int customNumber;
    private final int ladderHeight;

    public Ladder(int customNumber, int ladderHeight) {
        if(ladderHeight < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 3이상만 가능합니다.");
        }
        this.customNumber = customNumber;
        this.ladderHeight = ladderHeight;
    }
}
