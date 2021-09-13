package nextstep.ladder.model;

public class Player {
    public static final int START_HEIGHT = 0;

    private final int startWidth;

    public Player(int startWidth) {
        this.startWidth = startWidth;
    }

    public int climb(Ladder ladder) {
        int currentWidth = startWidth;
        for (int currentHeight = START_HEIGHT; currentHeight < ladder.height(); currentHeight++) {
            currentWidth = getCurrentWidth(currentWidth, currentHeight, ladder);
        }
        return currentWidth;
    }

    private int getCurrentWidth(int currentWidth, int currentHeight, Ladder ladder) {
        if (ladder.canGoLeft(currentWidth, currentHeight)) {
            return currentWidth - 1;
        }
        if (ladder.canGoRight(currentWidth, currentHeight)) {
            return currentWidth + 1;
        }
        return currentWidth;
    }
}
