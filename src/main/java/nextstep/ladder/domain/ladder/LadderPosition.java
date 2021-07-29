package nextstep.ladder.domain.ladder;

public class LadderPosition {
    private final int position;

    private LadderPosition(int position) {
        this.position = position;
    }

    public static LadderPosition from(int position) {
        return new LadderPosition(position);
    }
}
