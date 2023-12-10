package nextstep.ladder.model;

public class Ladder {

    private static final int MIN_HEIGHT = 1;

    private final Participants participants;
    private final Lines lines;
    private final Integer height;

    public Ladder(Participants participants, Lines lines, Integer height) {
        validateHeight(height);
        this.participants = participants;
        this.lines = lines;
        this.height = height;
    }

    private void validateHeight(Integer height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 최소 1 이상이어야 합니다.");
        }
    }


}
