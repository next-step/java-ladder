package nextstep.ladder.model;

public class Player {
    private final int startWidth;

    public Player(int startWidth) {
        this.startWidth = startWidth;
    }

    public int climb(Ladder ladder) {
        return ladder.climb(startWidth);
    }
}
